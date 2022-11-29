function getGrade(score) {
  let grade = '';
  let arrNotes = [
    [25, 30, 'A'],
    [20, 25, 'B'],
    [15, 20, 'C'],
    [10, 15, 'D'],
    [5, 10, 'E'],
    [0, 15, 'F'],
  ];
  let cont = 0;
  let data = [];
  // Write your code here
  console.log('grade', grade);
  while (grade.length == 0) {
    data = arrNotes[cont].toString().split(',');
    if (score > parseInt(data[0]) && score <= parseInt(data[1])) {
      grade = data[2];
    }
    cont++;
  }
  return grade;
}

var sco = 11;
getGrade(sco);
