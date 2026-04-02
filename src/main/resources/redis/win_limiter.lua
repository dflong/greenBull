-- keys[1]: 限流key
-- argv[1]: 当前时间戳（毫秒）
-- argv[2]: 窗口大小（毫秒）
-- argv[3]: 最大请求数
-- argv[4]: 唯一请求ID（防止重复）

local key = KEYS[1]
local now = tonumber(ARGV[1])
local window = tonumber(ARGV[2])
local limit = tonumber(ARGV[3])
local requestId = ARGV[4]

-- 1. 移除窗口之前的记录
local clearBefore = now - window
redis.call('ZREMRANGEBYSCORE', key, 0, clearBefore)

-- 2. 获取当前窗口内的请求数
local current = redis.call('ZCARD', key)

-- 3. 如果未超过限制
if current < limit then
    -- 添加当前请求
    redis.call('ZADD', key, now, requestId)
    -- 设置过期时间（窗口大小+1秒，确保数据不会提前消失）
    redis.call('PEXPIRE', key, window + 1000)
    return 1  -- 允许
else
    return 0  -- 拒绝
end