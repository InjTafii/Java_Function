
public class Graph {
    
    int[][] a;
    int n;
    char[] v;
    
    Graph() {
        v = "ABCDEFGHIJKLMN".toCharArray(); //v[0] = 'A',  v[4] ='E'
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
        System.out.print(v[i] + " ");
    }

    //(1)
    void breadth(boolean[] en, int i) {
        int j, r;
        MyQueue q = new MyQueue();
        q.enqueue(i);
        en[i] = true; //đánh dấu đã thêm vào hàng đợi
        while (!q.isEmpty()) {
            r = q.dequeue();
            visit(r);
            //thêm các đỉnh kề với r vào hàng đợi
            for (j = 0; j < n; j++) {
                if (!en[j] && a[r][j] > 0) {
                    q.enqueue(j);
                    en[j] = true;
                }
            }
        }
    }
    
    void breadth(int k) {
        boolean en[] = new boolean[n];
        int i;
        for (i = 0; i < n; i++) {
            en[i] = false; //khởi tạo giá trị cho mảng en
        }
        breadth(en, k);
        for (i = 0; i < n; i++) {
            if (!en[i]) {
                breadth(en, i);
            }
        }
    }

    //(2)
    void depth(boolean[] vis, int i) {
        visit(i);
        vis[i] = true;
        for (int j = 0; j < n; j++) {
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
    
}
