public class FloydWarshallProblem {
    final static int INF = 99999; // تمثل اللانهاية

    public static void main(String[] args) {
        // مصفوفة الإدخال
        int[][] graph = {
                {0, 3, INF, INF},
                {2, 0, INF, INF},
                {INF, 7, 0, 1},
                {6, INF, INF, 0}
        };

        // تطبيق الخوارزمية
        solveFloydWarshall(graph);
    }

    public static void solveFloydWarshall(int[][] graph) {
        int n = graph.length;
        int[][] dist = new int[n][n];

        // نسخ مصفوفة الإدخال إلى المصفوفة النهائية
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // الخوارزمية
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != INF && dist[k][j]!=INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        // طباعة النتيجة
        printMatrix(dist);
    }

    private static void printMatrix(int[][] matrix) {
        int n = matrix.length;
        System.out.println("Matrix of shortest distances:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(matrix[i][j] + "   ");
                }
            }
            System.out.println();
        }
    }
}
/*
مثال توضيحي:
افترض أن لديك الرسم البياني التالي (يمثل المدن والمسافات بينها):

       (A)----3----(B)
        |           |
       2|           |7
        |           |
       (C)----1----(D)

A	B	C	D
A	0	3	∞	∞
B	2	0	∞	∞
C	∞	7	0	1
D	6	∞	∞	0
الهدف: إيجاد أقصر مسافة بين كل زوج من المدن.

حل المشكلة:
عند تشغيل الكود، ستحصل على الجدول النهائي الذي يحتوي على أقصر المسافات بين كل زوج من المدن.

المصفوفة النهائية:
A	B	C	D
A	0	3	10	11
B	2	0	9	10
C	7	7	0	1
D	6	9	16	0
شرح النتائج:
المسافة من A إلى C هي 10 (A → B → C).
المسافة من B إلى D هي 10 (B → C → D).
لاحظ أن المسارات قد تحتوي على عدة عقد وسيطة لتحسين النتائج.

*/
