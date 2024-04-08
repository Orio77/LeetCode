import java.util.HashSet;
import java.util.Set;

// My futile attempt with weird loop jumping

// class Solution {
//     public boolean isValidSudoku(char[][] board) {
//         Set<Character> squareSet = new HashSet<>();
//         Map<Integer, Set<Character>> rowMap  = new HashMap<>();
        
//         rowLoop:
//         for (int row = 0; row < board.length; row++) { 
//             int square = 0;
//             goRightSquare:
//             for (square = 0; square < 3; square++) {
//                 int newRow = row;
//                 goDown:
//                 for (newRow = row; newRow < 3; newRow++) {
//                     int collumn = 0;
//                     goRghtNumber:
//                     for (collumn = 0; collumn < 3; collumn++) {
                        
//                     }
//                 }
//             }
//             row += 3;
//         }
//     }
// }

// Almost there
// class Solution {
//     public boolean isValidSudoku(char[][] board) {
//         Set<Character> rows;
//         Set<Character> collumns;
//         Map<String, Set<Character>> squares;

//         for (int row = 0; row < board.length; row++) {
//             rows = new HashSet<>();
//             collumns = new HashSet<>();
//             squares = new HashMap<>();
//             for (int collumn = 0; collumn < board.length; collumn++) {
//                 if (board[row][collumn] == '.') {
//                     continue;
//                 }

//                 String rowKey = Integer.toString(row / 3);
//                 String collumnKey = Integer.toString(collumn / 3);
//                 String key = rowKey.concat(collumnKey);

//                 if (rows.contains(board[row][collumn]) || collumns.contains(board[row][collumn]))
//                     return false;

//                 if (squares.containsKey(key)) {
//                     if (squares.get(key).contains(board[row][collumn])) {
//                         return false;
//                     }
//                 }

//                 rows.add(board[row][collumn]);
//                 collumns.add(board[row][collumn]);

//                 if (!squares.containsKey(key)) {
//                     squares.put(key, new HashSet<>());
//                 }
//                 squares.get(key).add(board[row][collumn]);
//             }
//         }
//         return true;
//     }
// }

// Solution
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                char number = board[i][j];
                if (number != '.') {
                    if (!seen.add(number + " in row " + i) || !seen.add(number + " in collumn " + j) || !seen.add(number + " in suqare "+ (i/3) + "-" + (j/3))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}