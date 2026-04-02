local key = KEYS[1]
local permits = tonumber(ARGV[1]) or 1
local now = tonumber(ARGV[2])
local rate = tonumber(ARGV[3])  -- 每interval*unit时间生成的令牌数
local capacity = tonumber(ARGV[4])
local interval = tonumber(ARGV[5])  -- 时间间隔倍数
local unit = tonumber(ARGV[6]) or 1000  -- 基础时间单位（毫秒）

-- 获取桶状态 令牌桶限流
local bucket = redis.call('HMGET', key, 'tokens', 'last_refill_time')
local current_tokens = 0
local last_refill_time = 0

if bucket[1] then
    -- 桶已存在
    current_tokens = tonumber(bucket[1])
    last_refill_time = tonumber(bucket[2]) or now
else
    -- 初始化桶
    current_tokens = capacity
    last_refill_time = now
    redis.call('HMSET', key,
        'rate', rate,
        'capacity', capacity,
        'interval', interval,
        'unit', unit,
        'last_refill_time', last_refill_time,
        'tokens', current_tokens)
    redis.call('PEXPIRE', key, math.floor(interval * unit * 2 / 1000))
end

-- 计算应添加的令牌数
local time_passed = math.max(0, now - last_refill_time)
-- 关键修正：考虑interval参数
local interval_unit_ms = interval * unit  -- 一个完整间隔的毫秒数
local time_passed_in_intervals = time_passed / interval_unit_ms
local tokens_to_add = math.floor(time_passed_in_intervals * rate)

-- 更新令牌数
current_tokens = math.min(capacity, current_tokens + tokens_to_add)
-- 计算新的刷新时间
local new_refill_time = last_refill_time + math.floor(tokens_to_add * interval_unit_ms / rate)

-- 判断是否有足够令牌
if current_tokens >= permits then
    current_tokens = current_tokens - permits
    redis.call('HSET', key, 'tokens', current_tokens, 'last_refill_time', new_refill_time)
    return 1
else
    redis.call('HSET', key, 'tokens', current_tokens, 'last_refill_time', new_refill_time)
    return 0
end