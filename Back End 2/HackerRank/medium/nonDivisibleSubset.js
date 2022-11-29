// of S where the sum of any 2 numbers in S' is not evenly divisible by k.

// Example
// S = [19,10,12,10,24,25,22]   k = 4

// One of the arrays that can be created is S'[0] = [10,12,25].
//  Another is S'[1] = [19,22,24]. After testing all permutations,
// the maximum length solution array has 3 elements.
function nonDivisibleSubset(k, s) {
  // Write your code here
  let arrPrint = [];
  let sum = 0;
  let repeatedElement = [];
  for (let i = 0; i < s.length; i++) {
    for (let j = i + 1; j < s.length; j++) {
      sum = s[i] + s[j];
      if (sum % k !== 0) {
        console.log('sum ', (s[i] + s[j]) % k);
        repeatedElement = arrPrint.filter((x) => x == s[i]);
        console.log(repeatedElement);
        if (repeatedElement.length == 0 || arrPrint.length == 0) {
          arrPrint.push(s[i]);
        }
        if (i === arrPrint.length - 1) {
          arrPrint.push(s[j]);
        }
        // repeatedElement = arrPrint.filter((x) => x == s[j]);
        // if (repeatedElement.length == 0) {
        //   arrPrint.push(s[j]);
        // }
      } else {
        console.log('rejected', s[i], s[j]);
        s = s.filter((x) => x !== s[j]);
      }
    }
  }
  console.log('arrPrint', arrPrint);
}

var arrayIntegers = [5, 10, 35, 14, 8];
arrayIntegers = [1, 7, 2, 4];
arrayIntegers = [
  278,
  576,
  496,
  727,
  410,
  124,
  338,
  149,
  209,
  702,
  282,
  718,
  771,
  575,
  436,
];
//arrayIntegers = [1, 2, 3, 4, 5, 6, 7, 8];
var kNumber = 7;

//arrayIntegers = [1, 2, 3, 7, 8];
nonDivisibleSubset(kNumber, arrayIntegers);
