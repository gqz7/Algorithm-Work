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
    document.getElementById('prvday').addEventListener('click', previous_day);
    document.getElementById('prvday').addEventListener('click', previous_day);

//functions
    window.onload = () => {

        computerDate = new Date(),
        dd = '28',
        //String(computerDate.getDate()).padStart(2, '0'),

        mm = '08',
        // String(computerDate.getMonth() + 1).padStart(2, '0'), //January is 0 so add 1 to .getMonth()
        
        yyyy =  '2000',
        // computerDate.getFullYear(),

        currentDate = computerDate;

        set_date()

    }

    
    function set_date() {
        today = yyyy + '-' + mm + '-' + dd;
        document.getElementById('date').innerText = today;
    }

    // document.getElementById('nxtday').addEventListener('click', next_day);
    // document.getElementById('prvday').addEventListener('click', previous_day);


    function next_day() {

        console.log(daysInMonth[mm-1]);
       
        if (parseInt(dd) + 1 > daysInMonth[mm-1] && mm < 12) {
            mm = mm < 9 ? "0" + (parseInt(mm)+1) : (parseInt(mm)+1);
            dd = "01";
        } else if (parseInt(dd) + 1 > daysInMonth[mm-1] && mm == 12) {
            // today = (parseInt(yyyy) + 1) + '-' + 01 + '-' + '01';
            yyyy = (parseInt(yyyy) + 1);
            mm = '01';
            dd = '01';
        } else if (parseInt(dd) + 1 <= daysInMonth[mm-1]) {

            if ((parseInt(dd) + 1 < 10)) {
                dd = "0" + (parseInt(dd) + 1);
            } else {
                dd = (parseInt(dd) + 1);
            }
           
        }

        set_date()

    }

    function previous_day() {
        
    }

    function next_month(){

        if (mm < 9) {
            mm = "0" + (parseInt(mm)+1);
        } else {
            mm = (parseInt(mm)+1);
        }

        set_date()

    }

    function previous_month(){
        
    }

    function next_year(){
        
    }

    function previous_year(){
        
    }

