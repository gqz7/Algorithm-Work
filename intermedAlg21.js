function orbitalPeriod(arr) {
    var GM = 398600.4418, earthRadius = 6367.4447;
    for (let i = 0; i < arr.length; i++) {

        let obj = arr[i];
        obj.orbitalPeriod = Math.round(2*Math.PI*(Math.sqrt(Math.pow(obj.avgAlt + earthRadius, 3)/GM)));
        delete obj.avgAlt;
        console.log(obj);
    }
    return arr;
  }
  
  orbitalPeriod([{name : "sputnik", avgAlt : 35873.5553}, {name: "iss", avgAlt: 413.6}, {name: "hubble", avgAlt: 556.7}, {name: "moon", avgAlt: 378632.553}]);
  