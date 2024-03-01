import java.util.*;

public class Main {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 1, 1},
                {0, 0, 1, 0, 1, 0, 1},
                {1, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 0, 0}
        };
        System.out.println("Исходное клетчатое поле");
        for (int[] ints : grid) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println();

        Set<Set<String>> figures = new HashSet<>(); // Для хранения найденных фигур
        Set<String> visited = new HashSet<>(); // Клетки которые мы уже посетили

        // Поиск фигур на клетчатом листе
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1 && !visited.contains(i + "_" + j)) {
                    // Если клетка была закрашена и еще не посещена, то создаем
                    // новую фигуру и запускаем рекурсивный обход dfs из данной клетки
                    Set<String> figure = new HashSet<>();
                    dfs(grid, i, j, figure, visited);
                    figures.add(figure);
                }
            }
        }

        System.out.println("Найденные фигуры на клетчатом листе бумаги:");
        for (Set<String> figure : figures) {
            System.out.println(figure);
        }

        Set<Set<String>> uniqueFigures = new HashSet<>(); // Для хранения уникальных фигур
        for (Set<String> figure1 : figures) {
            boolean was_identical = false; // Флаг встречалась ли нам идентичная фигура
            // Перебираем все имеющиеся уникальные фигуры и сравниваем их с текущей
            for (Set<String> figure2 : uniqueFigures) {
                Set<String> figure3 = new HashSet<>(figure2);
                if (figure1.size() != figure2.size()) {
                    // Если фигуры отличаются размером, то они точно неодинаковые
                    continue;
                }
                for (int i = 0; i < 4; ++i) {
                    // Если фигуры одинаковые, то устанавливаем флаг совпадения
                    if (areFiguresIdentical(figure1, figure3)) {
                        was_identical = true;
                        break;
                    }
                    figure3 = rotateFigure(figure3); // Поворачиваем фигуру
                }
            }
            if (!was_identical) {
                uniqueFigures.add(figure1); // Если не встретили одинаковых фигур, то добавляем фигуру к уникальным
            }
        }

        System.out.println("\nУникальные фигуры на клетчатом листе бумаги:");
        for (Set<String> figure : uniqueFigures) {
            System.out.println(figure);
        }
    }

    // Поиск в глубину рекурсивным методом Depth-First Search
    private static void dfs(int[][] grid, int i, int j, Set<String> figure, Set<String> visited) {
        // Проверка граничных условий, пустой или уже посещенной клетки
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || visited.contains(i + "_" + j)) {
            return;
        }

        visited.add(i + "_" + j); // Помечаем клетку как посещенную
        figure.add(i + "_" + j); // Добавляем клетку в формируемую фигуру

        // Запускаем дальнейший поиск фигуры для каждой из 4ех соседних клеток
        for (int[] direction : DIRECTIONS) {
            int newRow = i + direction[0];
            int newCol = j + direction[1];
            dfs(grid, newRow, newCol, figure, visited);
        }
    }

    // Проверка двух фигур на идентичность
    private static boolean areFiguresIdentical(Set<String> figure1, Set<String> figure2) {
        int[][] array1 = normalizeFigure(convertToArray(figure1)); // Нормализуем фигуры
        int[][] array2 = normalizeFigure(convertToArray(figure2));

        // Условием идентичности является одинаковая разница абсцисс и одинаковая разница ординат
        // каждой из пар точек двух фигур, если они отсортированы по возрастанию
        // Например, если есть две фигуры [0_0, 0_1, 1_0], [3_1, 3_2, 4_1], уже с отсортированными точками
        // то можно утверждать что фигуры идентичны, так как у абсцисс выполняется (3-0 = 3-0 = 4-1), а у ординат
        // выполняется (1-0 = 2-1 = 1-0)
        int diff1 = array1[0][0] - array2[0][0];
        int diff2 = array1[0][1] - array2[0][1];
        for (int i = 1; i < array1.length; ++i) {
            int diff3 = array1[i][0] - array2[i][0];
            int diff4 = array1[i][1] - array2[i][1];
            if (diff1 != diff3 || diff2 != diff4)
                return false;
        }
        return true;
    }

    // Преобразование сета в двумерный массив, чтобы его точки можно было в дальнейшем отсортировать
    private static int[][] convertToArray(Set<String> figure) {
        int[][] array = new int[figure.size()][2];
        int i = 0;
        for (String cord : figure) {
            String[] parts = cord.split("_");
            array[i][0] = Integer.parseInt(parts[0]);
            array[i][1] = Integer.parseInt(parts[1]);
            i++;
        }
        return array;
    }

    // Сортируем координаты фигуры по их абсциссам, а в случае равенства абсцисс по ординатам
    private static int[][] normalizeFigure(int[][] figure) {
        Arrays.sort(figure, (a, b) -> {
            int diffX = a[0] - b[0];
            return diffX != 0 ? diffX : a[1] - b[1];
        });
        return figure;
    }

    // Метод, поворачивающий фигуру на 90 градусов
    private static Set<String> rotateFigure(Set<String> figure) {
        Set<String> rotatedFigure = new HashSet<>();
        int centerX = 0;
        int centerY = 0;
        int numPoints = figure.size();

        // Находим центр фигуры
        for (String point : figure) {
            String[] parts = point.split("_");
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);
            centerX += x;
            centerY += y;
        }
        centerX /= numPoints;
        centerY /= numPoints;

        // Поворачиваем каждую точку на 90 градусов и добавляем в новую фигуру
        for (String point : figure) {
            String[] parts = point.split("_");
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);
            int newX = -(y - centerY) + centerX;
            int newY = (x - centerX) + centerY;
            rotatedFigure.add(newX + "_" + newY);
        }

        return rotatedFigure;
    }
}
