function getNumberOfOptions(
  priceOfJeans,
  priceOfShoes,
  priceOfSkirts,
  priceOfTops,
  dollars
) {
  let budgetFirst = [0];
  let minLeng = [
    [priceOfJeans.length, priceOfJeans.sort()],
    [priceOfShoes.length, priceOfShoes.sort()],
    [priceOfSkirts.length, priceOfSkirts.sort()],
    [priceOfTops.length, priceOfTops.sort()],
  ].sort();
  console.log('minLeng.length', minLeng.length);
  for (let i = 0; i < minLeng.length; i++) {
    console.log('array run', minLeng[i][1]);
    if (budgetFirst[0] <= dollars) {
      if (minLeng[i][0] == 1) {
        budgetFirst[0] += parseInt(minLeng[i][1]);
      } else {
        let newIndex = i;
        let j = 0;
        let budgetSecond = budgetFirst[0] + parseInt(minLeng[newIndex][1][0]);
        while (budgetSecond < dollars) {
            newIndex += 1;
            budgetSecond = budgetFirst + parseInt(minLeng[newIndex][1][0]);
            if (newIndex+1  < minLeng.length) {
                
                
            }else{

            }
        }

        // while (budgetSecond < dollars) {
        //   budgetFirst += parseInt(minLeng[newIndex][1][j]);
        //   newIndex += 1;
        //   if (newIndex >= minLeng.length) {
        //     newIndex = i;
        //     j++;
        //   }
        }
      }
    } else {
    }
    console.log('budget', budgetFirst);
  }
  console.log('minLeng', minLeng);
}

priceOfJeans = [2, 3];

priceOfShoes = [4, 1];

priceOfSkirts = [2, 1];

priceOfTops = [1, 2, 3];

dollars = 10;
getNumberOfOptions(
  priceOfJeans,
  priceOfShoes,
  priceOfSkirts,
  priceOfTops,
  dollars
);
