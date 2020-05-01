package com.example.nbasimple;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PlayersTeam implements Parcelable {
    @SerializedName("PlayerID")
    @Expose
    public Integer playerID;
    @SerializedName("SportsDataID")
    @Expose
    public String sportsDataID;
    @SerializedName("Status")
    @Expose
    public String status;
    @SerializedName("TeamID")
    @Expose
    public Integer teamID;
    @SerializedName("Team")
    @Expose
    public String team;
    @SerializedName("Jersey")
    @Expose
    public Integer jersey;
    @SerializedName("PositionCategory")
    @Expose
    public String positionCategory;
    @SerializedName("Position")
    @Expose
    public String position;
    @SerializedName("FirstName")
    @Expose
    public String firstName;
    @SerializedName("LastName")
    @Expose
    public String lastName;
    @SerializedName("Height")
    @Expose
    public Integer height;
    @SerializedName("Weight")
    @Expose
    public Integer weight;
    @SerializedName("BirthDate")
    @Expose
    public String birthDate;
    @SerializedName("BirthCity")
    @Expose
    public String birthCity;
    @SerializedName("BirthState")
    @Expose
    public String birthState;
    @SerializedName("BirthCountry")
    @Expose
    public Object birthCountry;
    @SerializedName("HighSchool")
    @Expose
    public Object highSchool;
    @SerializedName("College")
    @Expose
    public String college;
    @SerializedName("Salary")
    @Expose
    public Integer salary;
    @SerializedName("PhotoUrl")
    @Expose
    public String photoUrl;
    @SerializedName("Experience")
    @Expose
    public Integer experience;
    @SerializedName("SportRadarPlayerID")
    @Expose
    public String sportRadarPlayerID;
    @SerializedName("RotoworldPlayerID")
    @Expose
    public Integer rotoworldPlayerID;
    @SerializedName("RotoWirePlayerID")
    @Expose
    public Integer rotoWirePlayerID;
    @SerializedName("FantasyAlarmPlayerID")
    @Expose
    public Integer fantasyAlarmPlayerID;
    @SerializedName("StatsPlayerID")
    @Expose
    public Integer statsPlayerID;
    @SerializedName("SportsDirectPlayerID")
    @Expose
    public Integer sportsDirectPlayerID;
    @SerializedName("XmlTeamPlayerID")
    @Expose
    public Integer xmlTeamPlayerID;
    @SerializedName("InjuryStatus")
    @Expose
    public String injuryStatus;
    @SerializedName("InjuryBodyPart")
    @Expose
    public String injuryBodyPart;
    @SerializedName("InjuryStartDate")
    @Expose
    public Object injuryStartDate;
    @SerializedName("InjuryNotes")
    @Expose
    public String injuryNotes;
    @SerializedName("FanDuelPlayerID")
    @Expose
    public Integer fanDuelPlayerID;
    @SerializedName("DraftKingsPlayerID")
    @Expose
    public Integer draftKingsPlayerID;
    @SerializedName("YahooPlayerID")
    @Expose
    public Integer yahooPlayerID;
    @SerializedName("FanDuelName")
    @Expose
    public String fanDuelName;
    @SerializedName("DraftKingsName")
    @Expose
    public String draftKingsName;
    @SerializedName("YahooName")
    @Expose
    public String yahooName;
    @SerializedName("DepthChartPosition")
    @Expose
    public String depthChartPosition;
    @SerializedName("DepthChartOrder")
    @Expose
    public Integer depthChartOrder;
    @SerializedName("GlobalTeamID")
    @Expose
    public Integer globalTeamID;
    @SerializedName("FantasyDraftName")
    @Expose
    public String fantasyDraftName;
    @SerializedName("FantasyDraftPlayerID")
    @Expose
    public Integer fantasyDraftPlayerID;
    @SerializedName("UsaTodayPlayerID")
    @Expose
    public Integer usaTodayPlayerID;
    @SerializedName("UsaTodayHeadshotUrl")
    @Expose
    public String usaTodayHeadshotUrl;
    @SerializedName("UsaTodayHeadshotNoBackgroundUrl")
    @Expose
    public String usaTodayHeadshotNoBackgroundUrl;
    @SerializedName("UsaTodayHeadshotUpdated")
    @Expose
    public String usaTodayHeadshotUpdated;
    @SerializedName("UsaTodayHeadshotNoBackgroundUpdated")
    @Expose
    public String usaTodayHeadshotNoBackgroundUpdated;
    @SerializedName("NbaDotComPlayerID")
    @Expose
    public Integer nbaDotComPlayerID;

    public PlayersTeam(){}

    protected PlayersTeam(Parcel in) {
        this.playerID = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.sportsDataID = ((String) in.readValue((String.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.teamID = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.team = ((String) in.readValue((String.class.getClassLoader())));
        this.jersey = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.positionCategory = ((String) in.readValue((String.class.getClassLoader())));
        this.position = ((String) in.readValue((String.class.getClassLoader())));
        this.firstName = ((String) in.readValue((String.class.getClassLoader())));
        this.lastName = ((String) in.readValue((String.class.getClassLoader())));
        this.height = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.weight = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.birthDate = ((String) in.readValue((String.class.getClassLoader())));
        this.birthCity = ((String) in.readValue((String.class.getClassLoader())));
        this.birthState = ((String) in.readValue((String.class.getClassLoader())));
        this.birthCountry = ((Object) in.readValue((Object.class.getClassLoader())));
        this.highSchool = ((Object) in.readValue((Object.class.getClassLoader())));
        this.college = ((String) in.readValue((String.class.getClassLoader())));
        this.salary = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.photoUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.experience = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.sportRadarPlayerID = ((String) in.readValue((String.class.getClassLoader())));
        this.rotoworldPlayerID = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.rotoWirePlayerID = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.fantasyAlarmPlayerID = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.statsPlayerID = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.sportsDirectPlayerID = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.xmlTeamPlayerID = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.injuryStatus = ((String) in.readValue((String.class.getClassLoader())));
        this.injuryBodyPart = ((String) in.readValue((String.class.getClassLoader())));
        this.injuryStartDate = ((Object) in.readValue((Object.class.getClassLoader())));
        this.injuryNotes = ((String) in.readValue((String.class.getClassLoader())));
        this.fanDuelPlayerID = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.draftKingsPlayerID = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.yahooPlayerID = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.fanDuelName = ((String) in.readValue((String.class.getClassLoader())));
        this.draftKingsName = ((String) in.readValue((String.class.getClassLoader())));
        this.yahooName = ((String) in.readValue((String.class.getClassLoader())));
        this.depthChartPosition = ((String) in.readValue((String.class.getClassLoader())));
        this.depthChartOrder = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.globalTeamID = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.fantasyDraftName = ((String) in.readValue((String.class.getClassLoader())));
        this.fantasyDraftPlayerID = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.usaTodayPlayerID = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.usaTodayHeadshotUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.usaTodayHeadshotNoBackgroundUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.usaTodayHeadshotUpdated = ((String) in.readValue((String.class.getClassLoader())));
        this.usaTodayHeadshotNoBackgroundUpdated = ((String) in.readValue((String.class.getClassLoader())));
        this.nbaDotComPlayerID = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public static final Creator<PlayersTeam> CREATOR = new Creator<PlayersTeam>() {
        @Override
        public PlayersTeam createFromParcel(Parcel in) {
            return new PlayersTeam(in);
        }

        @Override
        public PlayersTeam[] newArray(int size) {
            return new PlayersTeam[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(playerID);
        dest.writeValue(sportsDataID);
        dest.writeValue(status);
        dest.writeValue(teamID);
        dest.writeValue(team);
        dest.writeValue(jersey);
        dest.writeValue(positionCategory);
        dest.writeValue(position);
        dest.writeValue(firstName);
        dest.writeValue(lastName);
        dest.writeValue(height);
        dest.writeValue(weight);
        dest.writeValue(birthDate);
        dest.writeValue(birthCity);
        dest.writeValue(birthState);
        dest.writeValue(birthCountry);
        dest.writeValue(highSchool);
        dest.writeValue(college);
        dest.writeValue(salary);
        dest.writeValue(photoUrl);
        dest.writeValue(experience);
        dest.writeValue(sportRadarPlayerID);
        dest.writeValue(rotoworldPlayerID);
        dest.writeValue(rotoWirePlayerID);
        dest.writeValue(fantasyAlarmPlayerID);
        dest.writeValue(statsPlayerID);
        dest.writeValue(sportsDirectPlayerID);
        dest.writeValue(xmlTeamPlayerID);
        dest.writeValue(injuryStatus);
        dest.writeValue(injuryBodyPart);
        dest.writeValue(injuryStartDate);
        dest.writeValue(injuryNotes);
        dest.writeValue(fanDuelPlayerID);
        dest.writeValue(draftKingsPlayerID);
        dest.writeValue(yahooPlayerID);
        dest.writeValue(fanDuelName);
        dest.writeValue(draftKingsName);
        dest.writeValue(yahooName);
        dest.writeValue(depthChartPosition);
        dest.writeValue(depthChartOrder);
        dest.writeValue(globalTeamID);
        dest.writeValue(fantasyDraftName);
        dest.writeValue(fantasyDraftPlayerID);
        dest.writeValue(usaTodayPlayerID);
        dest.writeValue(usaTodayHeadshotUrl);
        dest.writeValue(usaTodayHeadshotNoBackgroundUrl);
        dest.writeValue(usaTodayHeadshotUpdated);
        dest.writeValue(usaTodayHeadshotNoBackgroundUpdated);
        dest.writeValue(nbaDotComPlayerID);
    }

    @NonNull
    @Override
    public String toString() {
        return firstName + " " + lastName + " " + position;
    }
}
