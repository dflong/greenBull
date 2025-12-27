package com.dflong.greenbull.service;

import com.alibaba.fastjson.JSON;
import com.dflong.greenbull.entity.ContractInfo;
import com.dflong.greenbull.kafka.EventProducer;
import com.dflong.greenbull.kafka.KafkaConstant;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class RedisService {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    ContractService contractService;

    @Autowired
    EventProducer eventProducer;

    public ContractInfo getContractInfo(String unionId) {
        ContractInfo contractInfo = contractService.getContractInfo(unionId);
        for (int i = 0; i < 5; i++) {
            eventProducer.send(KafkaConstant.TOPIC, contractInfo.getContractId(), contractInfo.getState() + "");
        }








//        ValueOperations stringOps = redisTemplate.opsForValue();
//        stringOps.set(unionId, JSON.toJSONString(contractInfo));
//
//        HashMap<String, Object> maps = new HashMap<>();
        Set<ZSetOperations.TypedTuple> set = new HashSet<>();
//
        List<ContractInfo> contractInfoList = contractService.list();
        for (ContractInfo info : contractInfoList) {
//            maps.put(info.getContractId(), JSON.toJSONString(info));
            set.add(ZSetOperations.TypedTuple.of(info.getContractId(), info.getTotalAmount().doubleValue()));
        }
//        stringOps.multiSet(maps);
//
//        // 生成自增主键
////        stringOps.set("ContractInfoKey", "1");
//        Long contractInfoKey = stringOps.increment("ContractInfoKey");
//
//        HashOperations hashOperations = redisTemplate.opsForHash();
//
//        ListOperations listOperations = redisTemplate.opsForList();
//
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
        zSetOperations.add("contract_amount_ranking", set);
//
//        Set<ZSetOperations.TypedTuple> contractIds = zSetOperations.rangeWithScores("contract_amount_ranking", 2, 3);
//        System.out.println(JSON.toJSONString(contractIds));
//
//        SetOperations setOperations = redisTemplate.opsForSet();
//
//
//        runLua();

//        performTaskWithLock(unionId);
        return contractInfo;
    }

    // 扣库存
    public void runLua() {
//        redisTemplate.opsForValue().set("vehicle_model_stocking_count", "20");
        Object result = null;
        try {
            //调用lua脚本并执行（原子性操作）
            DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>();
            redisScript.setResultType(Long.class);//返回类型是Long
            //lua文件存放在resources目录下的redis文件夹内
            redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("redis/redis_stock.lua")));
            result = redisTemplate.execute(redisScript, Arrays.asList("vehicle_model_stocking_count"), "15");
            System.out.println("lock == " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void runPipelined() {
        redisTemplate.executePipelined(new SessionCallback<Object>() {
            @Override
            public <K, V> Object execute(RedisOperations<K, V> operations) throws DataAccessException {
                return null;
            }
        });
    }

    @Autowired
    private RedissonClient redissonClient;

    public void performTaskWithLock(String unionId) {
        RLock lock = redissonClient.getLock("myLock" + unionId);
        try {
            // 尝试获取锁，leaseTime = -1 才有看门狗
            boolean isLocked = lock.tryLock(0, -1, TimeUnit.SECONDS);
            if (isLocked) {
                try {
                    // 业务逻辑
                    System.out.println("锁定成功，执行任务");
                } finally {
                    // 确保锁被释放，只有持有锁的线程才能释放
                    if (lock.isHeldByCurrentThread()) {
                        lock.unlock();
                    }
                }
            } else {
                System.out.println("未能获取锁");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



