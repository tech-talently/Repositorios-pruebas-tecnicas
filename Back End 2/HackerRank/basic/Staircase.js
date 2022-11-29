// Staircase detail

// This is a staircase of size :

//    #
//   ##
//  ###
// ####
// Its base and height are both equal to . It is drawn using # symbols and spaces. The last line is not preceded by any spaces.

// Write a program that prints a staircase of size .


function symbolReturn(number, stringPrint){
    let variale = stringPrint
    //console.log('stringPrint', stringPrint, number)
    if (number >1 ){
       return variale +=symbolReturn(number-1, stringPrint); 
    }
    return variale;    
        
}

// Complete the staircase function below.
function staircase(n) {
    let spacePrint = '';
    let symbolPrint = '';
    for(let i=1; i<=n; i++){
        spacePrint = n-i>0? symbolReturn(n-i, ' '): '';
        //console.log('spacePrint', spacePrint);
        symbolPrint = symbolReturn(i, '#');
       // console.log('symbolPrint', symbolPrint);
       console.log(spacePrint + symbolPrint)
    }
}