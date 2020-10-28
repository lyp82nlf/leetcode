class LRUCache(capacity: Int) {
    /*
    *运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
    *获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
    *写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
    *
    *进阶:
    *
    *你是否可以在 O(1) 时间复杂度内完成这两种操作？
    * */
    /*
    * 查找O(1)  hashmap 可以实现
    * 插入删除优先级 数组队列实现不了  链表可以实现  使用双端队列 因为删除链表节点时 需要操作前节点才可以O(1)
    * */
    var doubleListNode = DoubleListNode()
    var dataMap = mutableMapOf<Int, Node>()
    var capacity = capacity
    fun get(key: Int): Int {
        var i = (dataMap[key]?.let {
            it as Node
            it.value
        }) ?: -1
        if (i != -1) {
            put(key, i)
        }
        return i
    }

    fun put(key: Int, value: Int) {
        var addFirst: Node? = null
        //doubleListNode已存在key
        dataMap[key]?.let {
            it.value = value
            doubleListNode.remove(it)
            addFirst = doubleListNode.addFirst(it)
            dataMap.put(key, addFirst!!)
            return
        }

        //不存在key
        if (capacity <= doubleListNode.size) {
            var removeLast = doubleListNode.removeLast()
            dataMap.remove(removeLast?.key)
        }
        addFirst = doubleListNode.addFirst(Node(key, value))

        dataMap.put(key, addFirst!!)
    }
}

class Node(var key: Int, var value: Int, var next: Node? = null, var prev: Node? = null) {
}

class DoubleListNode {
    var head: Node = Node(0, 0)
    var tail: Node = Node(0, 0)
    var size = 0

    init {
        head.next = tail
        tail.prev = head
    }

    fun addFirst(x: Node): Node {
        x.next = head.next
        x.prev = head
        head.next!!.prev = x
        head.next = x
        size++
        return x
    }

    fun removeLast(): Node? {
        var listNode = tail.prev
        remove(listNode!!)
        return listNode
    }

    fun remove(node: Node) {
        var currentNode = node
        currentNode.prev!!.next = currentNode.next
        currentNode.next!!.prev = currentNode.prev
        size--
    }
}

fun main() {
    val cache = LRUCache(2 /* 缓存容量 */);

    cache.put(2, 1);
    cache.put(2, 2);
    var get = cache.get(2);       // 返回  1
    cache.put(1, 1);    // 该操作会使得密钥 2 作废
    var get1 = cache.get(2);       // 返回 -1 (未找到)
    cache.put(4, 1);    // 该操作会使得密钥 1 作废
    var varget2 = cache.get(2);       // 返回 -1 (未找到)

    println(111)


}


