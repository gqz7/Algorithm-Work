//initalize variables
let computerDate, dd, mm, yyyy, today, currentDate;

const daysInMonth = [31,28,31,30,31,30,31,31,30,31,30,31];

//event listeners
    //day
    document.getElementById('nxtday').addEventListener('click', next_day);
    document.getElementById('prvday').addEventListener('click', previous_day);
    //month
    document.getElementById('nxtmonth').addEventListener('click', next_month);
    document.getElementById('prvmonth').addEventListener('click', previous_month);
    //year
    document.getElementById('nxtyear').addEventListener('click', next_year);
    document.getElementById('prvyear').addEventListener('click', previous_year);

//functions
    window.onload = () => {

        computerDate = new Date(), //creates a date objects when the screen loads
        dd = String(computerDate.getDate()).padStart(2, '0'), //gets all the neccecary data from the new Date obj
        mm = String(computerDate.getMonth() + 1).padStart(2, '0'), //January is 0 so add 1 to .getMonth()
        yyyy =  computerDate.getFullYear(), 
        currentDate = yyyy + '-' + mm + '-' + dd; //stores the current date and this will not be changed unless the page is reloaded
        set_date()

    }

    
    function set_date() { //this function will be called onload, aswell as every time the a button is pressed

        // console.log("test");

        today = yyyy + '-' + mm + '-' + dd;
        document.getElementById('date').innerText = today;
    }

    function next_day() { //WORKING
       
        if (parseInt(dd) + 1 > daysInMonth[mm-1] && mm < 12) { //if its going into the next month, but within the same year

            mm = mm < 9 ? "0" + (parseInt(mm)+1) : (parseInt(mm)+1);
            dd = "01";

        } else if (parseInt(dd) + 1 > daysInMonth[mm-1] && mm == 12) { //if its the last day of the year
            
            yyyy = (parseInt(yyyy) + 1);
            mm = '01';
            dd = '01';

        } else if ( parseInt(dd) + 1 <= daysInMonth[mm-1]) { //if it is not the end of the month

            if ((parseInt(dd) + 1 < 10)) { //if the date is less than 10 a 0 must be placed before the digit
                dd = "0" + (parseInt(dd) + 1);

            } else { //if it is greater or equal to 10 the format will be correct without addind the '0'
                dd = (parseInt(dd) + 1);

            }
           
        }

        set_date() //sets the date with changed values

    }

    function previous_day() { //WORKING

        if (parseInt(dd) - 1 === 0 && mm > 1) { //if it is the first of the month, the next day back will be the last day of the previous month

            mm = mm < 9 ? "0" + (parseInt(mm)-1) : (parseInt(mm)-1); //this ternary operator makes sure the months are correctly formated
            dd = daysInMonth[mm-1]; 
            // console.log(daysInMonth[mm-1]); //this will return the total number of days in the previous month
            
        } else if (parseInt(dd) - 1 === 0 && mm == 1) { //if is is January 1st then the date will be Dec. 31st on the year prior

            yyyy = (parseInt(yyyy) - 1);
            mm = '12';
            dd = '31';

        } else if (parseInt(dd) - 1 > 0) { //if it is any other day of the month but the first

            if ((parseInt(dd) - 1 < 10)) { //makes sure day formating is correct 
                dd = "0" + (parseInt(dd) - 1);

            } else {
                dd = (parseInt(dd) - 1);

            }
           
        }parseInt(dd)

        set_date() //sets the date with changed values
        
    }

    function next_month(){ //WORKING

        if (parseInt(mm) + 1 > 12) { //if the next month is the new year
            yyyy = (parseInt(yyyy) + 1);
            mm = '01';
            
        } else if (parseInt(mm) + 1 <= 12 && parseInt(mm) + 1 > 9) { //if next month is still within the calendar year
            mm = (parseInt(mm)+1);
        } else {  //these conditions assure corret formating
            mm = "0" + (parseInt(mm)+1);
        } 

        set_date() //sets the date with changed values

    }

    function previous_month(){ //WORKING

        if (parseInt(mm) - 1 < 1) {
            yyyy = (parseInt(yyyy) - 1);
            mm = '12';
            
        } else if (parseInt(mm) - 1 >= 1 && parseInt(mm) - 1 > 9) {
            mm = (parseInt(mm)-1);
        } else {
            mm = "0" + (parseInt(mm)-1);
        } 

        set_date() //sets the date with changed values
        
    }

    function next_year(){ //WORKING

        yyyy = (parseInt(yyyy) + 1); //very simple function but the '+=' can not be used because it is a string variable
 
        set_date() //sets the date with changed values
        
    }

    function previous_year(){ //WORKING

        yyyy = (parseInt(yyyy) - 1); //the variable must be parsed before the operator takes place.

        set_date() //sets the date with changed values
        
    }

