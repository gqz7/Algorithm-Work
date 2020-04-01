function checkCashRegister(price, cash, cid) {
  let change = [["PENNY", 0], ["NICKEL", 0], ["DIME", 0], ["QUARTER", 0], ["ONE", 0], ["FIVE", 0], ["TEN", 0], ["TWENTY", 0], ["ONE HUNDRED", 0]],
      changeValues = [0.01,.05,.1,.25,1,5,10,20,100], changeRequired = (cash - price), cidTotal = 0;

      for (let i = cid.length-1; i >= 0; i--) {

        while (cid[i][1] - changeValues[i] >= 0 && changeRequired - changeValues[i] >= 0) {
            cid[i][1] -= changeValues[i];
            cid[i][1] = Math.round(cid[i][1] * 100) / 100;

            change[i][1] += changeValues[i];
            change[i][1] = Math.round(change[i][1] * 100) / 100;

            changeRequired -= changeValues[i];
            changeRequired = Math.round(changeRequired * 100) / 100;
        }
        cidTotal += cid[i][1];
        cidTotal = Math.round(cidTotal * 100) / 100;

        // console.log(`Unit:${cid[i][0]}   Drawer:${cid[i][1]}   Change ${change[i][1]}, "Change needed:", ${changeRequired}`);
      }
        // console.log(change,cidTotal);

      let results;
        if (cidTotal > 0 && changeRequired == 0) {
            
            for (let i = 0; i < change.length; i++) {
                if (change[i][1] == 0) {
                    change.splice(i,1);
                    i--
                }
                
            }
            change = change.reverse();
            results = {status: "OPEN", change: change};

        } else if (cidTotal == 0 && changeRequired == 0) {
            results = {status: "CLOSED", change: change};

        } else if ( changeRequired > 0) {
            results = {status: "INSUFFICIENT_FUNDS", change: []};

        }
            console.log(results);
            return results;
        
}


// checkCashRegister(19.5, 20, [["PENNY", 1.01], ["NICKEL", 2.05], ["DIME", 3.1], ["QUARTER", 4.25], ["ONE", 90], ["FIVE", 55], ["TEN", 20], ["TWENTY", 60], ["ONE HUNDRED", 100]]);
// checkCashRegister(19.5, 20, [["PENNY", 0.5], ["NICKEL", 0], ["DIME", 0], ["QUARTER", 0], ["ONE", 0], ["FIVE", 0], ["TEN", 0], ["TWENTY", 0], ["ONE HUNDRED", 0]])
// checkCashRegister(19.5, 20, [["PENNY", 1.01], ["NICKEL", 2.05], ["DIME", 3.1], ["QUARTER", 4.25], ["ONE", 90], ["FIVE", 55], ["TEN", 20], ["TWENTY", 60], ["ONE HUNDRED", 100]])
checkCashRegister(3.26, 100, [["PENNY", 1.01], ["NICKEL", 2.05], ["DIME", 3.1], ["QUARTER", 4.25], ["ONE", 90], ["FIVE", 55], ["TEN", 20], ["TWENTY", 60], ["ONE HUNDRED", 100]])
