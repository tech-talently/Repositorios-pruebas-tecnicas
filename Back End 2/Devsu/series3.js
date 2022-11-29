// Write a method that receives a positive integer,
// and return the corresponding element of this series:
// 3, 4, 4, 12, 6, 20, 9, 28, 13, 36, 18, 44, ...
// If it’s 1, it should return the first element (3).
// If it receives 2, it should return the next element (4), and so on.
// x = 8311

var arrNumb = [3, 4, 4];

console.log(arrNumb[3]);

function numberN(n) {
  for (i = 3; i < n; i++) {
    let nextElementArray = 1;
    if (i % 2 == 1) {
      nextElementArray = arrNumb[i - 2] + 8;
    } else {
      if ((i - 1) % 3 == 0) {
        nextElementArray = arrNumb[i - 1] / 2;
      } else {
        nextElementArray = arrNumb[i - 1] / 2 - 1;
      }
    }

    arrNumb.push(nextElementArray);
  }
}
numberN(8311);
console.log(arrNumb);
console.log(arrNumb[8310]);
