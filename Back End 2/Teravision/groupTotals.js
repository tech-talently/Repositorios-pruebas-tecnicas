// Group Totals
// Have the function GroupTotals(strArr) read in the strArr parameter
//containing key:value pairs where the key is a string and the value is
//an integer. Your program should return a string with new key:value pairs
//separated by a comma such that each key appears only once with the total
//values summed up.

// For example: if strArr is ["B:-1", "A:1", "B:3", "A:5"] then your program
// should return the string A:6,B:2.
// Your final output string should return the keys in alphabetical order.
//Exclude keys that have a value of 0 after being summed up.

function GroupTotals(strArr) {
  // code goes here
  let groupTotal = [];
  strArr.sort();
  strArr.map((x) => {
    let newValue = x.split(':');
    groupTotal[newValue[0]]
      ? (groupTotal[newValue[0]] =
          parseInt(newValue[1]) + parseInt(groupTotal[newValue[0]]))
      : (groupTotal[newValue[0]] = newValue[1]);
    //console.log('newValue', newValue, 'groupTotal', groupTotal)
  });

  //  console.log('groupTotal>>',Object.entries(groupTotal))
  let filterGroup = [];
  Object.entries(groupTotal).map((x) => {
    //console.log(x[1])
    if (parseInt(x[1]) != 0) {
      filterGroup.push(`${x[0]}:${x[1]}`);
    }
  });

  //console.log('filterGroup', filterGroup)

  return filterGroup.toString();
}

let strArray = ['X:-1', 'Y:1', 'X:-4', 'B:3', 'X:5'];
console.log(GroupTotals(strArray));
strArray = ['B:-1', 'A:1', 'B:3', 'A:5'];
console.log(GroupTotals(strArray));
