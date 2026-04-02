//package com.dflong.algorithm.design;
//
//public class ZookeeperLock {
//
//    private ZooKeeper zk;
//    private String lockPath = "/locks/my_lock";
//    private String currentNode;
//    private String waitNode;
//
//    public boolean tryLock() throws Exception {
//        // 1. 创建临时顺序节点
//        currentNode = zk.create(lockPath + "/node_",
//                new byte[0],
//                ZooDefs.Ids.OPEN_ACL_UNSAFE,
//                CreateMode.EPHEMERAL_SEQUENTIAL);
//
//        // 2. 获取所有子节点并排序
//        List<String> children = zk.getChildren(lockPath, false);
//        Collections.sort(children);
//
//        // 3. 判断是否获取到锁
//        String nodeName = currentNode.substring(lockPath.length() + 1);
//        int index = children.indexOf(nodeName);
//
//        if (index == 0) {
//            // 最小节点，获取锁成功
//            return true;
//        } else {
//            // 监听前一个节点
//            waitNode = lockPath + "/" + children.get(index - 1);
//            final CountDownLatch latch = new CountDownLatch(1);
//            zk.exists(waitNode, event -> {
//                if (event.getType() == Watcher.Event.EventType.NodeDeleted) {
//                    latch.countDown();
//                }
//            });
//            // 等待前一个节点释放
//            latch.await();
//            return true;
//        }
//    }
//
//    public void unlock() throws Exception {
//        zk.delete(currentNode, -1);
//    }
//}
