let computerDate, dd, mm, yyyy, today, currentDate;

const months = [31,28,31,30,31,30,31,31,30,31,30,31];

    window.onload = () => {

        computerDate = new Date(),
        dd = '31',
        //String(computerDate.getDate()).padStart(2, '0'),
        mm = '12',
        // String(computerDate.getMonth() + 1).padStart(2, '0'), //January is 0!
        yyyy =  '2000',
        // computerDate.getFullYear(),
        today,
        currentDate = today;

        set_date()

    }

    
    function set_date() {
        today = yyyy + '-' + mm + '-' + dd,
        document.getElementById('date').innerHTML = today;
    }

    document.getElementById('nxtday').addEventListener('click', next_day);
    document.getElementById('prvday').addEventListener('click', previous_day);


    function next_day() {
       
        if (parseInt(dd) + 1 > 31 && mm < 12) {
            mm = "0" + (parseInt(mm) + 1);
            dd = "01";
        } else if (parseInt(dd) + 1 > 31 && mm == 12) {
            // today = (parseInt(yyyy) + 1) + '-' + 01 + '-' + '01';
            yyyy = (parseInt(yyyy) + 1);
            mm = '01';
            dd = '01';
        } else if (parseInt(dd) + 1 < 31) {

            if ((parseInt(dd) + 1 < 10)) {
                today = yyyy + '-' + mm + '-0' + (parseInt(dd) + 1);
            } else {
                today = yyyy + '-' + mm + '-' + (parseInt(dd) + 1);
            }
           
        }

        set_date()

    }

    function previous_day() {
        
    }

