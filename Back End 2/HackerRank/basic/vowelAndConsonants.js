function vowelsAndConsonants(s) {
  console.log("chain>>", s);
  let vowelsArray = ["a", "e", "i", "o", "u", "A", "E", "I", "O", "U"];
  let vowelArray = [];
  let arrayChain = s.split("");
  for (let index = 0; index < arrayChain.length; index++) {
    let indexVowel = vowelsArray.findIndex((e) => e == arrayChain[index]);
    
    if (indexVowel >= 0) {
      vowelArray.push(arrayChain[index]);
    }
  }
  //console.log("printArray>>>", vowelArray);


  let printArray = vowelArray.concat(arrayChain.filter(c =>!vowelArray.includes(c)));
  printArray.forEach(l => console.log(l));
}

let stringChain = "vowelsAndConsonants";
vowelsAndConsonants(stringChain);
