var x = 10;
var y = 4;
function calc(x, y) {
  let cont = x;
  for (let i = 2; i <= y; i++) {
    cont = cont * i;
  }
  console.log(cont);
}
console.log(x, y);
calc(x, y);

x = 3;
y = 10;
console.log(x, y);
calc(x, y);
