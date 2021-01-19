package graph

import java.util.*
import kotlin.reflect.jvm.internal.impl.utils.DFS

class IsBipartite {
    val UN_COLOR = 0
    val RED = 1
    val BLUE = 2
    fun isBipartite(graph: Array<IntArray>): Boolean {
        val visited = IntArray(graph.size)
        val queue = LinkedList<Int>()
        for (node in graph.withIndex()) {
            if (visited[node.index] != UN_COLOR) {
                continue
            }
            visited[node.index] = RED
            queue.offer(node.index)
            while (queue.isNotEmpty()) {
                val poll = queue.poll()
                for (i in graph[poll]) {
                    if (visited[i] == visited[poll]) {
                        return false
                    }
                    if (visited[i] == UN_COLOR) {
                        visited[i] = getReverseColor(visited[poll])
                    }
                    queue.offer(i)
                }
            }
        }
        return true
    }

    fun isBipartiteDFS(graph: Array<IntArray>): Boolean {
        val visited = IntArray(graph.size)
        for (node in graph.withIndex()) {
            if (visited[node.index] == UN_COLOR && !dfs(graph, node.index, RED, visited)) {
                return false
            }
        }
        return true
    }

    private fun dfs(graph: Array<IntArray>, index: Int, color: Int, visited: IntArray): Boolean {
        if (visited[index] != UN_COLOR) {
            return visited[index] == color
        }

        visited[index] = color
        for (node in graph[index]) {
            if (!dfs(graph, node, getReverseColor(color), visited)) {
                return false
            }
        }
        return true
    }

    fun getReverseColor(color: Int): Int {
        return if (color == RED) BLUE else RED
    }
}

fun main() {
    print(IsBipartite().isBipartite(arrayOf(intArrayOf(4), intArrayOf(), intArrayOf(4), intArrayOf(4), intArrayOf(0, 2, 3))))
}