// Complete the miniMaxSum function below.
function miniMaxSum(arr) {
  let sumItems = 0;

  arr.sort();
  console.log(arr);
  arr.forEach((x) => {
    sumItems += x;
  });
  console.log("minSum", sumItems - arr[arr.length - 1]);
  console.log("maxSum", sumItems - arr[0]);
}

var arraySum1 = [1, 4, 5, 2, 3];
var arraySum2 = [9, 6, 7, 8, 5];

miniMaxSum(arraySum1);
miniMaxSum(arraySum2);
