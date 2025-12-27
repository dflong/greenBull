package com.dflong.greenbull.kafka;

public class KafkaConstant {

    public static final String TOPIC = "vehicle_contract_pay";

    public static final String GROUP_ID = "vehicle_contract_groups";

    public static final int NUM_PARTITIONS = 4;

    public static final short REPLICATION_FACTOR = 2;


    public static final String DEAD_LETTER_TOPIC = "DEAD_LETTER_TOPIC";

    public static final String TRANSACTION_ID_PREFIX = "tx-";
}
