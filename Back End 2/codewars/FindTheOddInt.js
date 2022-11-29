function findOdd(arrayNumber) {
    var contOdd = 1; 
      var arraySecond = [];
      var arraCont = []; 
      let oddNumber = false;
      let oddInteger = 0;    
      while (!oddNumber){
          arraySecond = arrayNumber;
          for (let  i = 1; i < arraySecond.length ; i++) {            
              if(arrayNumber[0] === arraySecond[i]){
                  contOdd = contOdd+1;
                  console.log('coincidence', arrayNumber[0], contOdd, ' ',i);
                  arrayNumber.splice(i, 1);
                  i = i-1;
              }
          }
          console.log('recorred array: ', arrayNumber, ' length: ', arrayNumber.length);
          arraCont.push([arrayNumber[0],contOdd]); 
          if(contOdd % 2 == 1){
              oddInteger = arrayNumber[0]; 
              console.log('number odd times: ', arrayNumber[0]); 
              oddNumber =true;
              i= arraySecond.length;            
          }else{
              contOdd=1;  
              arrayNumber.splice(0,1);
              console.log('new array: ', arrayNumber, ' length: ', arrayNumber.length);
          }        
      }
      console.log('arraCont', arraCont);
    
    return oddInteger; 
  }

function bestSolution(A){
    var obj = {};
  A.forEach(function(el){
    obj[el] ? obj[el]++ : obj[el] = 1;
    console.log(obj[el]);
  });
  
  for(prop in obj) {
    if(obj[prop] % 2 !== 0) return Number(prop);
  }
}


const arrayNumber = [20,  1, -4, 2, -2,  3, 3, 5,  5,  1, 2,  4, 20, 4,-4, -2,  5]
bestSolution(arrayNumber); 