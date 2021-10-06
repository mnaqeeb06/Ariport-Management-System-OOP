package p_airport;

//There are different flight schedule according to time(we are considering morning , evening and night)
interface flights_Details {

    public String Detail();

}
//implementing day time schedule 

class day_time_flights implements flights_Details {

    @Override
    public String Detail() {

        return "Saudi Arabia : 7 am 4/19/2021";
    }

}
//implementing evening time schedule 

class evening_time_flights implements flights_Details {

    @Override
    public String Detail() {
        return "Turkey : 9 am 4/19/2021";
    }
}
//implementing night time schedule 

class night_time_flights implements flights_Details {

    @Override
    public String Detail() {
        return "USA : 11 am 4/19/2021";
    }

}
