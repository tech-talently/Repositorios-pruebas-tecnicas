function contiguousArr(arrCont) {
  let maxIndex = 0;
  let arrMax = arrCont[0];
  let sumArr = 0;
  for (let i = 0; i < arrCont.length; i++) {
    if (maxIndex < arrCont[i]) {
      arrMax = arrCont[i];
      matIndex = i;
    }
    console.log();
  }

  matIndex = matIndex * 2;
  for (let j = 0; j <= matIndex; j++) {
    sumArr += arrCont[j];
  }
  console.log(sumArr);
}

var arr = [-3.2, 4.2, 7.0, 5.4, -2.2, -2.5];
contiguousArr(arr);
