class Solution:
    def minReorder(self, n: int, connections: List[List[int]]) -> int:
        graph = defaultdict(list)
        directed = set()

        for a,b in connections:
            graph[a].append(b)
            graph[b].append(a)
            directed.add((a,b))

        v = [False] * n

        def dfs(node : int) -> int:
            v[node] = True
            changes = 0

            for neighbour in graph[node]:
                if not v[neighbour]:
                    if (node , neighbour) in directed:
                        changes += 1

                    changes += dfs(neighbour)
            return changes

        return dfs(0)



        