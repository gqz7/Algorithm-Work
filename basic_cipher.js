function rot13(str) { // LBH QVQ VG!
let alpha = /[A-Z]/;
  str = str.split('');
  for (var i = 0; i < str.length; i++) {
      if (alpha.test(str[i])) {
        str = String.fromCharCode(str.charCodeAt(i) + 13)
      }
  }
  str.join('');
  console.log(str)
  return str;
}

// Change the inputs below to test
rot13("SERR PBQR PNZC");
