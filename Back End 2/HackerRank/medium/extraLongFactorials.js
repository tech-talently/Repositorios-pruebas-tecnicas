// The factorial of the integer , written , is defined as:
// Calculate and print the factorial of a given integer.
// For example, if n=5, we calculate 5x4x3x2x1 and get 120.
// Function Description
// Complete the extraLongFactorials function in the editor below. It should print the result and return.

function extraLongFactorials(n) {
  let factorialN = BigInt(1);

  for (let i = 1; i <= n; i++) {
    factorialN = BigInt(i) * BigInt(factorialN);
  }
  console.log(factorialN.toString());
  let printFact = factorialN.toString().replace("n", "");
  console.log(printFact);
}

var n = [25, 15, 35];

n.forEach((x) => extraLongFactorials(x));
