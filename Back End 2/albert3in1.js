function stateBoard(arr) {
  let state = '';
  for (let i = 0; i < arr.length; i++) {
    if (arr[i][0] == arr[i][1] && arr[i][1] == arr[i][2]) {
      state = arr[i][0].trim() == '' ? 'inconclusive' : arr[i][0] + 'winner';
      i = arr.length;
    } else {
      if (arr[0][i] == arr[1][i] && arr[1][i] == arr[2][i]) {
        state = arr[0][i] + 'winner';
        i = arr.length;
      } else {
        if ((arr[i][0] + arr[i][1] + arr[i][2]).length < 3) {
          state = 'inconclusive';
        } else {
          state = 'tied';
        }
      }
    }
  }
  return state;
}

const board = [
  ['x', 'x', 'x'],
  ['x', 'o', 'x'],
  ['o', 'x', 'o'],
];

const board2 = [
  ['x', 'o', 'x'],
  ['x', 'o', 'o'],
  ['o', 'o', 'x'],
];

const board3 = [
  ['x', 'x', 'o'],
  ['x', 'o', 'x'],
  ['o', 'x', ''],
];

const board4 = [
  ['x', 'x', 'x'],
  ['x', 'o', 'x'],
  ['', '', ''],
];

console.log('board1: ' + stateBoard(board));
console.log('board2: ' + stateBoard(board2));
console.log('board3: ' + stateBoard(board3));
console.log('board4: ' + stateBoard(board4));
// let stateB = stateBoard(board3)
// console.log(stateB)
/* 
  Your previous Python 3 content is preserved below:
  
  """
  Possible States: X-Winner, O-Winner, Tie, Inconclusive
  Example Boards:
  X | X | X
    |   | 
    |   |  
  
  O |   | X
  O |   | 
  O |   | O
  
  X | O | X
  X | X | O
  O | X | X
  
  X | O | X
  O | X | X
  O | X | O
  
  X |   | X
  O |   | 
    | X |  
  
  X | O | X
  O | X | 
  O | X | O
  """
  
  def say_hello():
      print('Hello, World')
      
  for i in range(5):
      say_hello()
  
   */
