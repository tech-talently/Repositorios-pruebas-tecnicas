// Create a function thath, given an array of floating point numbers,
//find the contiguous subarray with the largest product,
// and then sum the contents of the array.

// The subarray can be of any length, it could even be the whole array.

var arr = [-3.2, 4.2, 7.0, 5.4, -2.2, -2.5];
function contiguousArr(arrCont) {
  let productReference = 1;
  let productA = 1;
  let arrContig = [];
  let productAll = 1;
  let subArray = [];
  for (let i = arrCont.length - 1; i > 0; i--) {
    productAll = productAll * arrCont[i];
  }
  console.log('productAll', productAll);
  for (let j = arrCont.length - 1; j > 0; j--) {
    for (let k = j - 1; k > 0; k--) {
      productReference = productReference * arrCont[k];
      arrContig.push(arrCont[k]);
    }
    if (productReference > productAll) {
      productAll = productReference;
      subArray = arrContig;
    }
    productReference = 1;
  }
  console.log('productAll', productAll);

  console.log('subArray', subArray);
  console.log('productReference', productReference);
}

contiguousArr(arr);
