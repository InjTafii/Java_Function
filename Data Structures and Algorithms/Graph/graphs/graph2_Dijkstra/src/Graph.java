
public class Graph {

    int[][] a;
    int n;
    char[] v;

    Graph() {
        v = "ABCDEFGHIJKLMN".toCharArray();
    }

    void setData(int[][] b) {
        n = b.length;
        int i, j;
        a = new int[n][n];
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                a[i][j] = b[i][j];
            }
        }
    }

    void dispAdj() {
        int i, j;
        for (i = 0; i < n; i++) {
            System.out.println();
            for (j = 0; j < n; j++) {
                System.out.printf("%5d", a[i][j]);
            }
        }
        System.out.println();

    }

    void visit(int i) {
        System.out.print(v[i] + "  ");
    }

    void breadth(boolean[] en, int i) {
        MyQueue q = new MyQueue();
        q.enqueue(i);
        en[i] = true;
        int j, r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            visit(r);
            for (j = 0; j < n; j++) {
                if (!en[j] && a[r][j] > 0) {
                    q.enqueue(j);
                    en[j] = true;
                }
            }
        }
    }

    void breadth(int k) {
        boolean[] en = new boolean[n];
        int i;
        for (i = 0; i < n; i++) {
            en[i] = false;
        }
        breadth(en, k);
        for (i = 0; i < n; i++) {
            if (!en[i]) {
                breadth(en, i);
            }
        }
    }

    void depth(boolean[] vis, int i) {
        visit(i);
        vis[i] = true;
        int j;
        for (j = 0; j < n; j++) {
            if (!vis[j] && a[i][j] > 0) {
                depth(vis, j);
            }
        }
    }

    void depth(int k) {
        boolean[] vis = new boolean[n];
        int i;
        for (i = 0; i < n; i++) {
            vis[i] = false;
        }
        depth(vis, k);
        for (i = 0; i < n; i++) {
            if (!vis[i]) {
                depth(vis, i);
            }
        }
    }

    //(1)
    void dijkstra(int fro, int to) {
        int INF = 99;
        boolean[] S = new boolean[n];
        int[] d = new int[n];//khoảng cách ngắn nhất từ gốc đến đích 
        int[] p = new int[n];//lưu lại các đỉnh của đường đi ngắn nhất
        int i, j, k, min;
        for (i = 0; i < n; i++) {
            S[i] = false;
            d[i] = a[fro][i];//khoảng cách từ front đến i
            p[i] = fro;
        }
        S[fro] = true;
        while (true) {
            //tìm k sao cho d[k] min
            min = INF;
            k = -1;
            for (i = 0; i < n; i++) {
                if (S[i]) {
                    continue;//Đỉnh nào được chọn rồi thì bỏ qua
                }
                if (d[i] < min) {
                    min = d[i];
                    k = i;
                }
            }
            if (k == -1) {
                System.out.println("No solution");
                return;
            }
            //Chọn k
            S[k] = true;
            if (k == to) { //Gặp đỉnh đích thì break
                break;
            }
            //Kiểm tra xem đi thẳng hay đi vòng oke hơn
            //hay nói cách khách là đi cập nhật lại d[i]
            for (i = 0; i < n; i++) {
                if (S[i]) {
                    continue;
                }
                if (d[i] > d[k] + a[k][i]) {//nếu đi theo cách cũ lơn hơn đi theo cách mới( di qua k)
                    d[i] = d[k] + a[k][i];
                    p[i] = k;// bổ sung đỉnh trước đỉnh i là đỉnh k
                }
            }
        }
        System.out.println("The shortest distance is: " + d[to]);
        System.out.println("The path is:  ");
        i = to;
        MyStack s = new MyStack(); //duyệt từ cuối về để tìm đường đi ngắn nhất
        s.push(i);
        while (true) {
            i = p[i];
            s.push(i);
            if (i == fro) {
                break;
            }
        }

        i = s.pop();
        System.out.print(i);
        while (!s.isEmpty()) {
            i = s.pop();
            System.out.print(" -> " + i);
        }
        System.out.println();
    }
}
