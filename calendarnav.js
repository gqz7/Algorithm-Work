let computerDate, dd, mm, yyyy, today, currentDate;

    window.onload = () => {

        computerDate = new Date(),
        dd = String(computerDate.getDate()).padStart(2, '0'),
        mm = String(computerDate.getMonth() + 1).padStart(2, '0'), //January is 0!
        yyyy = computerDate.getFullYear(),
        today = yyyy + '-' + mm + '-' + dd,
        currentDate = today;

        set_date()

    }

    
    function set_date() {
        document.getElementById('date').innerHTML = today;
    }

    document.getElementById('nxtday').addEventListener('click', next_day);
    document.getElementById('prvday').addEventListener('click', previous_day);

    function daysInMonth(month, year) {
        return 32 - new Date(year, month, 32).getDate();
    }
  
    function next_day() {

        console.log(today);

        if (parseInt(dd) + 1 > daysInMonth(mm,yyyy) && mm < 12) {
            today = yyyy + '-' + (parseInt(mm) + 1) + '-' + '01';
        } else if (parseInt(dd) + 1 > 31 && mm == 12) {
            today = (parseInt(yyyy) + 1) + '-' + 01 + '-' + '01';
        } else if (parseInt(dd) + 1 < daysInMonth(mm,yyyy)) {

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

