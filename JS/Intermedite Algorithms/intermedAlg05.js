
  function spinalCase(str) {
    // "It's such a fine line between stupid, and clever."
    // --David St. Hubbins
    str = str.replace(/([a-z])([A-Z])/g, "$1 $2").toLowerCase().replace(/_/g, " ").trim().split(" ").join("-");
    console.log(str);
    return str;
  }
  
  spinalCase("AllThe-smallThings");
  