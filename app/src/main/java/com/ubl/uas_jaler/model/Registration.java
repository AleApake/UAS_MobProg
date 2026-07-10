package com.ubl.uas_jaler.model;

public class Registration {

    private int id;
    private int userId;
    private int tournamentId;

    private String teamName;
    private String institution;

    private String player1;
    private String player2;
    private String player3;
    private String player4;
    private String player5;

    private String gameId1;
    private String gameId2;
    private String gameId3;
    private String gameId4;
    private String gameId5;

    // Constructor kosong
    public Registration() {
    }

    // Constructor lengkap
    public Registration(int id, int userId, int tournamentId,
                        String teamName, String institution,
                        String player1, String player2, String player3,
                        String player4, String player5,
                        String gameId1, String gameId2, String gameId3,
                        String gameId4, String gameId5) {

        this.id = id;
        this.userId = userId;
        this.tournamentId = tournamentId;
        this.teamName = teamName;
        this.institution = institution;

        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
        this.player4 = player4;
        this.player5 = player5;

        this.gameId1 = gameId1;
        this.gameId2 = gameId2;
        this.gameId3 = gameId3;
        this.gameId4 = gameId4;
        this.gameId5 = gameId5;
    }

    // Getter & Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(int tournamentId) {
        this.tournamentId = tournamentId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public String getPlayer3() {
        return player3;
    }

    public void setPlayer3(String player3) {
        this.player3 = player3;
    }

    public String getPlayer4() {
        return player4;
    }

    public void setPlayer4(String player4) {
        this.player4 = player4;
    }

    public String getPlayer5() {
        return player5;
    }

    public void setPlayer5(String player5) {
        this.player5 = player5;
    }

    public String getGameId1() {
        return gameId1;
    }

    public void setGameId1(String gameId1) {
        this.gameId1 = gameId1;
    }

    public String getGameId2() {
        return gameId2;
    }

    public void setGameId2(String gameId2) {
        this.gameId2 = gameId2;
    }

    public String getGameId3() {
        return gameId3;
    }

    public void setGameId3(String gameId3) {
        this.gameId3 = gameId3;
    }

    public String getGameId4() {
        return gameId4;
    }

    public void setGameId4(String gameId4) {
        this.gameId4 = gameId4;
    }

    public String getGameId5() {
        return gameId5;
    }

    public void setGameId5(String gameId5) {
        this.gameId5 = gameId5;
    }
}