// Given a number n, for each integer i in the range from 1 to n inclusive, print one value per line as follows:

// If i is a multiple of both 3 and 5, print FizzBuzz.
// If i is a multiple of 3 (but not 5), print Fizz.
// If i is a multiple of 5 (but not 3), print Buzz.
// If i is not a multiple of 3 or 5, print the value of i.
function fizzBuzz(n) {
  // Write your code here
  for (let i = 1; i <= n; i++) {
    let stringPrint = "";
    if (i % 3 == 0) {
      stringPrint += "Fizz";
    }
    if (i % 5 == 0) {
      stringPrint += "Buzz";
    }
    if (i % 3 !== 0 && i % 5 !== 0) {
      stringPrint = i;
    }
    console.log(stringPrint);
  }
}

var n = [9, 15, 30, 45];
for (let i = 0; i < n.length; i++) {
  console.log("Serie con n: ", n[i]);
  fizzBuzz(n[i]);
}
