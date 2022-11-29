function possibleChanges(usernames) {
  // Write your code here
  let results = [];

  for (let i = 0; i < usernames.length; i++) {
    let element = usernames[i];
    console.log(element);
    let arrayLettersName = element.split("");
    let sortedArrayLetterName = element.split("").sort();
    for (let indexSorted = 0; indexSorted < sortedArrayLetterName.length; indexSorted++) {
      let item = sortedArrayLetterName[indexSorted];
      console.log(item, "==>", indexSorted, arrayLettersName[indexSorted], "==>");

      if (arrayLettersName[indexSorted] !== item) {
        var indexLetter = sortedArrayLetterName.findIndex((e) => e == arrayLettersName[indexSorted]);
        console.log(indexLetter);
        if (indexSorted < indexLetter) {
          results.push("Yes");
          indexSorted = sortedArrayLetterName.length;
        }
      }
      if (indexSorted == sortedArrayLetterName.length - 1) {
        results.push("No");
      }
    }
  }
  console.log(results);
}

var arr = ["adam", "jose", "pepe", "hydra", "boo", "faz","bee"];

var yesNoArray = possibleChanges(arr);
console.log(arr);