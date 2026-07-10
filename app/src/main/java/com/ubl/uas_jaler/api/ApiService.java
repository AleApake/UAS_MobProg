package com.ubl.uas_jaler.api;


import com.ubl.uas_jaler.model.ApiResponse;
import com.ubl.uas_jaler.model.Registration;
import com.ubl.uas_jaler.model.Tournament;
import com.ubl.uas_jaler.model.User;


import java.util.List;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;



public interface ApiService {

    // LOGIN USER
    @FormUrlEncoded
    @POST("users/login.php")
    Call<ApiResponse> loginUser(

            @Field("nickname") String nickname,

            @Field("email") String email,

            @Field("phone") String phone

    );


    // GET TOURNAMENT RecyclerView Dashboard
    @GET("tournaments/getTournament.php")
    Call<List<Tournament>> getTournament();


    // CREATE REGISTRATION Daftar Tournament
    @FormUrlEncoded
    @POST("registrations/registerTeam.php")
    Call<ApiResponse> registerTeam(
            @Field("user_id")
            int userId,
            @Field("tournament_id")
            int tournamentId,
            @Field("team_name")
            String teamName,
            @Field("institution")
            String institution,

            @Field("player1")
            String player1,
            @Field("player2")
            String player2,
            @Field("player3")
            String player3,
            @Field("player4")
            String player4,
            @Field("player5")
            String player5,

            @Field("gameid1")
            String gameId1,
            @Field("gameid2")
            String gameId2,
            @Field("gameid3")
            String gameId3,
            @Field("gameid4")
            String gameId4,
            @Field("gameid5")
            String gameId5

    );


    // READ REGISTRATION MyRegistration

    @GET("registrations/getRegistration.php")
    Call<List<Registration>> getRegistration();


    // UPDATE REGISTRATION
    @FormUrlEncoded
    @POST("registrations/updateRegistration.php")
    Call<ApiResponse> updateRegistration(


            @Field("id")
            int id,


            @Field("user_id")
            int userId,


            @Field("tournament_id")
            int tournamentId,


            @Field("team_name")
            String teamName,


            @Field("institution")
            String institution,



            @Field("player1")
            String player1,


            @Field("player2")
            String player2,


            @Field("player3")
            String player3,


            @Field("player4")
            String player4,


            @Field("player5")
            String player5,



            @Field("gameid1")
            String gameId1,


            @Field("gameid2")
            String gameId2,


            @Field("gameid3")
            String gameId3,


            @Field("gameid4")
            String gameId4,


            @Field("gameid5")
            String gameId5

    );


    // DELETE REGISTRATION

    @FormUrlEncoded
    @POST("registrations/deleteRegistration.php")
    Call<ApiResponse> deleteRegistration(

            @Field("id")
            int id

    );


}