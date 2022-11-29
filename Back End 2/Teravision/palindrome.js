// Palindrome
// Have the function Palindrome(str) take the str parameter being passed
//and return the string true if the parameter is a palindrome,
//(the string is the same forward as it is backward) otherwise
//return the string false. For example: "racecar" is also "racecar"
// backwards. Punctuation and numbers will not be part of the string.
// Examples
// Input: "never odd or even"
// Output: true
// Input: "eye"
// Output: true

function Palindrome(str) {
  let strWSpaces = str.replace(/ /g, '');
  let checkPalindrome = false;
  let varPalind = strWSpaces.split('');
  let palindrome = '';
  //console.log(varPalind.length)
  for (let i = varPalind.length - 1; i >= 0; i--) {
    palindrome = palindrome + varPalind[i];
    // console.log('palindrome', palindrome, 'varPalind[i]', i,varPalind[i])
  }
  if (palindrome == strWSpaces) {
    checkPalindrome = true;
  }
  //console.log(varPalind);
  // code goes here
  return checkPalindrome;
}

// keep this function call here
console.log(Palindrome(readline()));
