//my
function booWho(bool) {
    if(typeof bool === 'boolean'){
      return true;
    }else{
      return false;
    }
  }
  
  booWho(null);
  //other
  function booWho(bool) {
    return typeof bool === 'boolean';
  }
