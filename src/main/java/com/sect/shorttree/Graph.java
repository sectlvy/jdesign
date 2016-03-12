package com.sect.shorttree;

/**
 * ͼ����С·�� ���ߣ����� ��Դ���й���ѧ����� �������ڣ�1211963544
 * 
 * ����ʹ�õ���Dijkstra���������·������ʵ��Dijkstra���ʱ��ָ���ڵ㵽���нڵ����С·�����������
 * 
 * �㷨�������£�
 * 
 * ׼�����������������ݽṹ��
 * 
 * 1 ParentLength �� ������¼����ǰ�ڵ�֮ǰ�ĸ��ڵ㣬�뵽��ǰ�ڵ����С·��
 * 
 * 2 Path��
 * ��¼ָ���ڵ㵽���нڵ��ParentLength����ʼ��ʱ�����е�ParentLength�ĸ��ڵ㶼Ϊָ������ʼ�ڵ㣬���ȶ���INFINITY
 * ������û����ͨ�����������
 * 
 * Path�Ĺؼ��㷨��adjust(from,to,length)��ÿ������һ���µģ���һ���ѷ��ʵĽڵ㣨from����δ���ʵĽڵ㣨to��֮�����·��ʱ��
 * Path���������ParentLength�б�
 * �����¼��㵽�Ǹ�δ���ʽڵ㣨to�������¾��룺��ǰ��from�ڵ�ľ��룫�µľ��룬Ȼ��Ƚ�����to�ڵ��Ӧ��ParentLength�ϵľ���֮��ĳ���
 * ������¾����
 * ����to�ڵ��Ӧ��ParentLength����Ϊ����Ϊ�¾���ģ����ڵ�Ϊfrom���Դ˲��豣֤Path���Ǳ��ֵ�ǰ����״̬�£��������ڵ�����·����
 * 
 * Path����һ���ؼ��㷨��getMin�����᷵�ص�����δ���ʽڵ��У���̵�·�����Ǹ��ڵ㡣
 * 
 * ͼʹ���ڽӾ��󷨱�ʾ�������ڽӾ���ɲμ���Graph ͼ���ڽӱ�
 * 
 * Graph.path����С·���㷨��������ʽ���£�
 * 
 * ����ָ������ʼ�ڵ��ʼ������ֵPath����
 * 
 * ��ָ������ʼ�ڵ��־Ϊ�ѷ��ʡ�������Ϊ��ǰ�ڵ㡣
 * 
 * Ȼ��
 * 
 * 1 �ҵ���ǰ�ڵ�������ͨ��δ֪�ڵ㣬�͵���Щ·�����ȣ�����Path.adjust����Path��
 * 
 * 2 ���� 1 �����󣬴ӵ���Path.getMin��õ�����δ���ʽڵ��У���̵�·�����Ǹ��ڵ㡣��־Ϊ���ʹ�������Ϊ��ǰ�ڵ㡣
 * 
 * 3 �ظ� ���� 1 ���� 2 n�Σ�nΪͼ�еĽڵ����������㷨������
 * 
 * �����е�Path.print()Ϊ��ӡ������Ϊ����֮�á�
 * 
 * Path.main()�ṩ�򵥲��ԡ�
 * 
 * 
 * 
 * Java����
 **/
class ParentLength { // ������һ���ڵ��뵱ǰ��С·��
	private int parent; // ��һ���ڵ�
	private int length; // ��С·������

	ParentLength(int parent, int length) {
		this.parent = parent;
		this.length = length;
	}

	int parent() {
		return parent;
	}

	int length() {
		return length;
	}
}

class Path { // �洢��С·��
	private ParentLength[] pls;
	private Graph g; // ȷ��ָ��λ�õĽڵ��Ƿ񱻷��ʹ��ʹ�ӡʱʹ��

	Path(int size, int start, Graph g) {
		// ��ʼ����С·�����飬��������С·������㶼��Ϊstart������·��������ΪINFINITY
		pls = new ParentLength[size];
		for (int i = 0; i < size; i++)
			pls[i] = new ParentLength(start, Graph.INFINITY);
		this.g = g;
	}

	// �����·��ֵ�·��������С·��
	void adjust(int from, int to, int length) {
		// ������һ���ڵ��·����������µ�·������
		int newLength = pls[from].length() != Graph.INFINITY ? pls[from]
				.length() + length : length;
		// �����ָ���ڵ����·������С��ԭ������С·��������µ��ýڵ����С·�������丸�ڵ�
		if (newLength < pls[to].length())
			pls[to] = new ParentLength(from, newLength);
	}

	int getMin() { // ��õ���ǰ����δ���ʽڵ�������һ���ڵ�
		int pos = 0;
		for (int i = 1; i < pls.length; i++)
			if (!g.isVisited(i) && pls[i].length() < pls[pos].length())
				pos = i;
		return pos;
	}

	void print() { // ��ӡ
		for (int i = 0; i < pls.length; i++) {
			int current = i;
			System.out
					.print((pls[current].length() == Graph.INFINITY ? "INFINITY"
							: pls[current].length())
							+ " ");
			do {
				System.out.print(g.get(current) + " <-- ");
				current = pls[current].parent();
			} while (current != pls[current].parent());
			System.out.println(g.get(current));
		}
	}
}

class Vertex { // ����,��������value���������Ƿ���ʹ�
	private Object value;
	private boolean isVisited;

	Vertex(Object value) {
		this.value = value;
	}

	void visit() {
		isVisited = true;
	}

	void clean() {
		isVisited = false;
	}

	boolean isVisited() {
		return isVisited;
	}

	Object value() {
		return value;
	}

	@Override
	public String toString() {
		return "" + value;
	}
}

class Graph {
	private Vertex[] vertexs;
	private int[][] adjMat;
	private int length = 0;
	static final int INFINITY = ~(1 << 31); // ���������ֵ����ʾû��·��

	Graph(int size) { // ��ʼ��
		vertexs = new Vertex[size];
		adjMat = new int[size][size];
		for (int i = 0; i < size; i++)
			// ���ڽӾ����ʼ��Ϊȫ����ͨ
			for (int j = 0; j < size; j++)
				adjMat[i][j] = INFINITY;
	}

	void add(Object value) { // ��Ӷ���
		assert length <= vertexs.length;
		vertexs[length++] = new Vertex(value);
	}

	void connect(int from, int to, int length) {
		adjMat[from][to] = length; // ����ָ���ڵ�֮�������·��
	}

	/**
	 * ���ڽӾ����У�����ָ�������δ���ʹ��ھӶ��� ����Ӵ���㵽�յ�ıߴ��ڣ���û�б�־Ϊ���ʣ��򷵻��յ��±ꡣ
	 * 
	 * @param offset
	 *            ָ����ʼ���ҵ���
	 * @param index
	 *            ָ�����ҵ���
	 */
	int findNeighbor(int index, int offset) {
		for (int i = offset; i < length; i++) {
			if (adjMat[index][i] != INFINITY && !vertexs[i].isVisited())
				return i;
		}
		return -1;
	}

	Vertex get(int index) {
		return vertexs[index];
	}

	Path path(int index) { // ��С·���㷨
		assert vertexs[index] != null;
		Path result = new Path(length, index, this); // ��ʼ��Path
		vertexs[index].visit(); // ����ʵ�ڵ��־Ϊ���ʹ�
		for (int n = 1; n < length; n++) { // һ������n�˵����Ϳɵõ����ս��
			int i = 0;
			while ((i = findNeighbor(index, i + 1)) != -1)
				// Ѱ�ҵ�ǰ�ڵ������Ϊ�����ھ�
				result.adjust(index, i, adjMat[index][i]); // ������·�ߵ�����С·��
			index = result.getMin(); // ����ǰ�ڵ����Ϊ·������Ϊ���ʵ�������Ǹ��ڵ�
			vertexs[index].visit(); // ����ǰ�ڵ��־Ϊ���ʹ�;
		}
		clean();
		return result;
	}

	boolean isVisited(int index) {
		return vertexs[index].isVisited();
	}

	void clean() {
		for (Vertex v : vertexs)
			if (v != null)
				v.clean();
	}

	public static void main(String[] args) {
		Graph g = new Graph(20);
		// ��ӽڵ�
		g.add('a');
		g.add('b');
		g.add('c');
		g.add('d');
		g.add('e');
		// ���������Ȩ��
		g.connect(0, 1, 50);
		g.connect(0, 3, 80);
		g.connect(1, 2, 60);
		g.connect(1, 3, 90);
		g.connect(2, 4, 40);
		g.connect(3, 2, 20);
		g.connect(3, 4, 70);
		g.connect(4, 1, 50);
		Path p = g.path(0); // �����С·��
		p.print(); // ��ӡ
	}
}
