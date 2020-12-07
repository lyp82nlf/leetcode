import Utils.TreeNode
import TreeNode.generateTreeNodeList
import java.util.*

class Codec {
    fun reSerialize(root: TreeNode?, str: String): String {
        var str = str

        return root?.let {
            str += "${root.`val`},"
            str = reSerialize(root.left, str)
            str = reSerialize(root.right, str)
            str
        } ?: "${str}None,"
    }


    fun serialize(root: TreeNode?): String {
        return reSerialize(root, "")
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        var split = data.split(',')
        return reDeserialize(LinkedList(split))
    }

    fun reDeserialize(data: LinkedList<String>): TreeNode? {
        if (data[0] == "None") {
            data.removeAt(0)
            return null
        }

        val root = TreeNode(data[0].toInt())
        data.removeAt(0)
        root.left = reDeserialize(data)
        root.right = reDeserialize(data)
        return root
    }

}

// 3,9,None,None,20,15,None,None,7,None,None
fun main() {
    var generateTreeNodeList = generateTreeNodeList()
    println(Codec().serialize(generateTreeNodeList))
}