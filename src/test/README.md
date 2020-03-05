## Simple Graph lib:
# Should support 2 types of graphs - directed and undirected with 3 operations:
 addVertex - adds vertex to the graph
 addEdge - adds edge to the graph
 getPath - returns a list of edges between 2 vertices (path doesn’t have to be optimal)
 Vertices should be of a user defined type.
 Questions to be ready to answer (don’t have to implement):
 Add weighted edges support in your lib.
Add traverse function that will take a user defined function and apply it on every vertex of the graph.
Например функция, которая поищет есть-ли определенная вершина или просто залоггирует все существующие вершины и т.д.
Это должна быть функция графа которая принимает Supplier

Make you graphs thread safe.
Потокобезопасность к вставке вершин и ребер, чтобы они не аффектили поиск пути
