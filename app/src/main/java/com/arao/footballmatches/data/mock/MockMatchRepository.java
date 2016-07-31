package com.arao.footballmatches.data.mock;

import com.arao.footballmatches.data.entity.League;
import com.arao.footballmatches.data.entity.MatchesFilter;
import com.arao.footballmatches.data.repository.DataCallback;
import com.arao.footballmatches.data.repository.MatchRepository;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MockMatchRepository implements MatchRepository {

    @Inject
    MockMatchRepository() {

    }

    @Override
    public void matches(MatchesFilter filter, DataCallback<List<League>> callback) {
        String jsonString = "{\"name\":\"Premier League\",\"additionalName\":null,\"image\":{\"objectCode\":\"country\",\"objectId\":\"2\",\"title\":null,\"type\":\"flag\"},\"relatedToObjectCode\":\"tournament\",\"relatedToObjectId\":\"47\",\"hasStandings\":true,\"matches\":[{\"id\":2252178,\"name\":\"Hull - Leicester\",\"startDate\":1471087800,\"countryId\":2,\"countryName\":\"England\",\"tournamentId\":47,\"tournamentName\":\"Premier League\",\"tournamentShortName\":\"Premier L.\",\"sportId\":1,\"statusId\":1,\"statusCode\":\"notstarted\",\"statusDesc\":\"Not started\",\"statusShortDesc\":\"NS\",\"elapsed\":0,\"elapsedText\":null,\"isTicking\":false,\"ballPossession\":0,\"outcome\":null,\"predictionOpened\":true,\"teams\":[{\"id\":8667,\"number\":1,\"name\":\"Hull\",\"shortName\":\"Hull\",\"threeCharsName\":\"HUL\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/8667.png\"},{\"id\":8197,\"number\":2,\"name\":\"Leicester\",\"shortName\":\"Leicester\",\"threeCharsName\":\"LEI\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/8197.png\"}]},{\"id\":2252174,\"name\":\"Burnley - Swansea\",\"startDate\":1471096800,\"countryId\":2,\"countryName\":\"England\",\"tournamentId\":47,\"tournamentName\":\"Premier League\",\"tournamentShortName\":\"Premier L.\",\"sportId\":1,\"statusId\":1,\"statusCode\":\"notstarted\",\"statusDesc\":\"Not started\",\"statusShortDesc\":\"NS\",\"elapsed\":0,\"elapsedText\":null,\"isTicking\":false,\"ballPossession\":0,\"outcome\":null,\"predictionOpened\":true,\"teams\":[{\"id\":8191,\"number\":1,\"name\":\"Burnley\",\"shortName\":\"Burnley\",\"threeCharsName\":\"BUR\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/8191.png\"},{\"id\":10003,\"number\":2,\"name\":\"Swansea\",\"shortName\":\"Swansea\",\"threeCharsName\":\"SWA\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/10003.png\"}]},{\"id\":2252176,\"name\":\"Crystal Palace - West Bromwich\",\"startDate\":1471096800,\"countryId\":2,\"countryName\":\"England\",\"tournamentId\":47,\"tournamentName\":\"Premier League\",\"tournamentShortName\":\"Premier L.\",\"sportId\":1,\"statusId\":1,\"statusCode\":\"notstarted\",\"statusDesc\":\"Not started\",\"statusShortDesc\":\"NS\",\"elapsed\":0,\"elapsedText\":null,\"isTicking\":false,\"ballPossession\":0,\"outcome\":null,\"predictionOpened\":true,\"teams\":[{\"id\":9826,\"number\":1,\"name\":\"Crystal Palace\",\"shortName\":\"Crystal P.\",\"threeCharsName\":\"CRY\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/9826.png\"},{\"id\":8659,\"number\":2,\"name\":\"West Bromwich\",\"shortName\":\"West Brom\",\"threeCharsName\":\"WBA\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/8659.png\"}]},{\"id\":2252177,\"name\":\"Everton - Tottenham\",\"startDate\":1471096800,\"countryId\":2,\"countryName\":\"England\",\"tournamentId\":47,\"tournamentName\":\"Premier League\",\"tournamentShortName\":\"Premier L.\",\"sportId\":1,\"statusId\":1,\"statusCode\":\"notstarted\",\"statusDesc\":\"Not started\",\"statusShortDesc\":\"NS\",\"elapsed\":0,\"elapsedText\":null,\"isTicking\":false,\"ballPossession\":0,\"outcome\":null,\"predictionOpened\":true,\"teams\":[{\"id\":8668,\"number\":1,\"name\":\"Everton\",\"shortName\":\"Everton\",\"threeCharsName\":\"EVE\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/8668.png\"},{\"id\":8586,\"number\":2,\"name\":\"Tottenham\",\"shortName\":\"Tott'ham\",\"threeCharsName\":\"TOT\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/8586.png\"}]},{\"id\":2252180,\"name\":\"Middlesbrough - Stoke\",\"startDate\":1471096800,\"countryId\":2,\"countryName\":\"England\",\"tournamentId\":47,\"tournamentName\":\"Premier League\",\"tournamentShortName\":\"Premier L.\",\"sportId\":1,\"statusId\":1,\"statusCode\":\"notstarted\",\"statusDesc\":\"Not started\",\"statusShortDesc\":\"NS\",\"elapsed\":0,\"elapsedText\":null,\"isTicking\":false,\"ballPossession\":0,\"outcome\":null,\"predictionOpened\":true,\"teams\":[{\"id\":8549,\"number\":1,\"name\":\"Middlesbrough\",\"shortName\":\"Mid'brough\",\"threeCharsName\":\"MID\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/8549.png\"},{\"id\":10194,\"number\":2,\"name\":\"Stoke\",\"shortName\":\"Stoke\",\"threeCharsName\":\"STO\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/10194.png\"}]},{\"id\":2252181,\"name\":\"Southampton - Watford\",\"startDate\":1471096800,\"countryId\":2,\"countryName\":\"England\",\"tournamentId\":47,\"tournamentName\":\"Premier League\",\"tournamentShortName\":\"Premier L.\",\"sportId\":1,\"statusId\":1,\"statusCode\":\"notstarted\",\"statusDesc\":\"Not started\",\"statusShortDesc\":\"NS\",\"elapsed\":0,\"elapsedText\":null,\"isTicking\":false,\"ballPossession\":0,\"outcome\":null,\"predictionOpened\":true,\"teams\":[{\"id\":8466,\"number\":1,\"name\":\"Southampton\",\"shortName\":\"Sou'ton\",\"threeCharsName\":\"SOU\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/8466.png\"},{\"id\":9817,\"number\":2,\"name\":\"Watford\",\"shortName\":\"Watford\",\"threeCharsName\":\"WAT\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/9817.png\"}]},{\"id\":2252179,\"name\":\"Manchester City - Sunderland\",\"startDate\":1471105800,\"countryId\":2,\"countryName\":\"England\",\"tournamentId\":47,\"tournamentName\":\"Premier League\",\"tournamentShortName\":\"Premier L.\",\"sportId\":1,\"statusId\":1,\"statusCode\":\"notstarted\",\"statusDesc\":\"Not started\",\"statusShortDesc\":\"NS\",\"elapsed\":0,\"elapsedText\":null,\"isTicking\":false,\"ballPossession\":0,\"outcome\":null,\"predictionOpened\":true,\"teams\":[{\"id\":8456,\"number\":1,\"name\":\"Manchester City\",\"shortName\":\"Man City\",\"threeCharsName\":\"MAC\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/8456.png\"},{\"id\":8472,\"number\":2,\"name\":\"Sunderland\",\"shortName\":\"Sun'land\",\"threeCharsName\":\"SUN\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/8472.png\"}]},{\"id\":2252173,\"name\":\"Bournemouth - Manchester United\",\"startDate\":1471177800,\"countryId\":2,\"countryName\":\"England\",\"tournamentId\":47,\"tournamentName\":\"Premier League\",\"tournamentShortName\":\"Premier L.\",\"sportId\":1,\"statusId\":1,\"statusCode\":\"notstarted\",\"statusDesc\":\"Not started\",\"statusShortDesc\":\"NS\",\"elapsed\":0,\"elapsedText\":null,\"isTicking\":false,\"ballPossession\":0,\"outcome\":null,\"predictionOpened\":true,\"teams\":[{\"id\":8678,\"number\":1,\"name\":\"Bournemouth\",\"shortName\":\"Bournemouth\",\"threeCharsName\":\"BOU\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/8678.png\"},{\"id\":10260,\"number\":2,\"name\":\"Manchester United\",\"shortName\":\"Man Utd\",\"threeCharsName\":\"MU\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/10260.png\"}]},{\"id\":2252172,\"name\":\"Arsenal - Liverpool\",\"startDate\":1471186800,\"countryId\":2,\"countryName\":\"England\",\"tournamentId\":47,\"tournamentName\":\"Premier League\",\"tournamentShortName\":\"Premier L.\",\"sportId\":1,\"statusId\":1,\"statusCode\":\"notstarted\",\"statusDesc\":\"Not started\",\"statusShortDesc\":\"NS\",\"elapsed\":0,\"elapsedText\":null,\"isTicking\":false,\"ballPossession\":0,\"outcome\":null,\"predictionOpened\":true,\"teams\":[{\"id\":9825,\"number\":1,\"name\":\"Arsenal\",\"shortName\":\"Arsenal\",\"threeCharsName\":\"ARS\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/9825.png\"},{\"id\":8650,\"number\":2,\"name\":\"Liverpool\",\"shortName\":\"Liv'pool\",\"threeCharsName\":\"LIV\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/8650.png\"}]},{\"id\":2252175,\"name\":\"Chelsea - West Ham\",\"startDate\":1471287600,\"countryId\":2,\"countryName\":\"England\",\"tournamentId\":47,\"tournamentName\":\"Premier League\",\"tournamentShortName\":\"Premier L.\",\"sportId\":1,\"statusId\":1,\"statusCode\":\"notstarted\",\"statusDesc\":\"Not started\",\"statusShortDesc\":\"NS\",\"elapsed\":0,\"elapsedText\":null,\"isTicking\":false,\"ballPossession\":0,\"outcome\":null,\"predictionOpened\":true,\"teams\":[{\"id\":8455,\"number\":1,\"name\":\"Chelsea\",\"shortName\":\"Chelsea\",\"threeCharsName\":\"CHE\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/8455.png\"},{\"id\":8654,\"number\":2,\"name\":\"West Ham\",\"shortName\":\"W. Ham\",\"threeCharsName\":\"WHA\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/8654.png\"}]},{\"id\":2252194,\"name\":\"Manchester United - Southampton\",\"startDate\":1471633200,\"countryId\":2,\"countryName\":\"England\",\"tournamentId\":47,\"tournamentName\":\"Premier League\",\"tournamentShortName\":\"Premier L.\",\"sportId\":1,\"statusId\":1,\"statusCode\":\"notstarted\",\"statusDesc\":\"Not started\",\"statusShortDesc\":\"NS\",\"elapsed\":0,\"elapsedText\":null,\"isTicking\":false,\"ballPossession\":0,\"outcome\":null,\"predictionOpened\":true,\"teams\":[{\"id\":10260,\"number\":1,\"name\":\"Manchester United\",\"shortName\":\"Man Utd\",\"threeCharsName\":\"MU\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/10260.png\"},{\"id\":8466,\"number\":2,\"name\":\"Southampton\",\"shortName\":\"Sou'ton\",\"threeCharsName\":\"SOU\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/8466.png\"}]},{\"id\":2252195,\"name\":\"Stoke - Manchester City\",\"startDate\":1471692600,\"countryId\":2,\"countryName\":\"England\",\"tournamentId\":47,\"tournamentName\":\"Premier League\",\"tournamentShortName\":\"Premier L.\",\"sportId\":1,\"statusId\":1,\"statusCode\":\"notstarted\",\"statusDesc\":\"Not started\",\"statusShortDesc\":\"NS\",\"elapsed\":0,\"elapsedText\":null,\"isTicking\":false,\"ballPossession\":0,\"outcome\":null,\"predictionOpened\":true,\"teams\":[{\"id\":10194,\"number\":1,\"name\":\"Stoke\",\"shortName\":\"Stoke\",\"threeCharsName\":\"STO\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/10194.png\"},{\"id\":8456,\"number\":2,\"name\":\"Manchester City\",\"shortName\":\"Man City\",\"threeCharsName\":\"MAC\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/8456.png\"}]},{\"id\":2252197,\"name\":\"Swansea - Hull\",\"startDate\":1471701600,\"countryId\":2,\"countryName\":\"England\",\"tournamentId\":47,\"tournamentName\":\"Premier League\",\"tournamentShortName\":\"Premier L.\",\"sportId\":1,\"statusId\":1,\"statusCode\":\"notstarted\",\"statusDesc\":\"Not started\",\"statusShortDesc\":\"NS\",\"elapsed\":0,\"elapsedText\":null,\"isTicking\":false,\"ballPossession\":0,\"outcome\":null,\"predictionOpened\":true,\"teams\":[{\"id\":10003,\"number\":1,\"name\":\"Swansea\",\"shortName\":\"Swansea\",\"threeCharsName\":\"SWA\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/10003.png\"},{\"id\":8667,\"number\":2,\"name\":\"Hull\",\"shortName\":\"Hull\",\"threeCharsName\":\"HUL\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/8667.png\"}]},{\"id\":2252198,\"name\":\"Tottenham - Crystal Palace\",\"startDate\":1471701600,\"countryId\":2,\"countryName\":\"England\",\"tournamentId\":47,\"tournamentName\":\"Premier League\",\"tournamentShortName\":\"Premier L.\",\"sportId\":1,\"statusId\":1,\"statusCode\":\"notstarted\",\"statusDesc\":\"Not started\",\"statusShortDesc\":\"NS\",\"elapsed\":0,\"elapsedText\":null,\"isTicking\":false,\"ballPossession\":0,\"outcome\":null,\"predictionOpened\":true,\"teams\":[{\"id\":8586,\"number\":1,\"name\":\"Tottenham\",\"shortName\":\"Tott'ham\",\"threeCharsName\":\"TOT\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/8586.png\"},{\"id\":9826,\"number\":2,\"name\":\"Crystal Palace\",\"shortName\":\"Crystal P.\",\"threeCharsName\":\"CRY\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/9826.png\"}]},{\"id\":2252199,\"name\":\"Watford - Chelsea\",\"startDate\":1471701600,\"countryId\":2,\"countryName\":\"England\",\"tournamentId\":47,\"tournamentName\":\"Premier League\",\"tournamentShortName\":\"Premier L.\",\"sportId\":1,\"statusId\":1,\"statusCode\":\"notstarted\",\"statusDesc\":\"Not started\",\"statusShortDesc\":\"NS\",\"elapsed\":0,\"elapsedText\":null,\"isTicking\":false,\"ballPossession\":0,\"outcome\":null,\"predictionOpened\":true,\"teams\":[{\"id\":9817,\"number\":1,\"name\":\"Watford\",\"shortName\":\"Watford\",\"threeCharsName\":\"WAT\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/9817.png\"},{\"id\":8455,\"number\":2,\"name\":\"Chelsea\",\"shortName\":\"Chelsea\",\"threeCharsName\":\"CHE\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/8455.png\"}]},{\"id\":2252200,\"name\":\"West Bromwich - Everton\",\"startDate\":1471701600,\"countryId\":2,\"countryName\":\"England\",\"tournamentId\":47,\"tournamentName\":\"Premier League\",\"tournamentShortName\":\"Premier L.\",\"sportId\":1,\"statusId\":1,\"statusCode\":\"notstarted\",\"statusDesc\":\"Not started\",\"statusShortDesc\":\"NS\",\"elapsed\":0,\"elapsedText\":null,\"isTicking\":false,\"ballPossession\":0,\"outcome\":null,\"predictionOpened\":true,\"teams\":[{\"id\":8659,\"number\":1,\"name\":\"West Bromwich\",\"shortName\":\"West Brom\",\"threeCharsName\":\"WBA\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/8659.png\"},{\"id\":8668,\"number\":2,\"name\":\"Everton\",\"shortName\":\"Everton\",\"threeCharsName\":\"EVE\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/8668.png\"}]},{\"id\":2252454,\"name\":\"Burnley - Liverpool\",\"startDate\":1471701600,\"countryId\":2,\"countryName\":\"England\",\"tournamentId\":47,\"tournamentName\":\"Premier League\",\"tournamentShortName\":\"Premier L.\",\"sportId\":1,\"statusId\":1,\"statusCode\":\"notstarted\",\"statusDesc\":\"Not started\",\"statusShortDesc\":\"NS\",\"elapsed\":0,\"elapsedText\":null,\"isTicking\":false,\"ballPossession\":0,\"outcome\":null,\"predictionOpened\":true,\"teams\":[{\"id\":8191,\"number\":1,\"name\":\"Burnley\",\"shortName\":\"Burnley\",\"threeCharsName\":\"BUR\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/8191.png\"},{\"id\":8650,\"number\":2,\"name\":\"Liverpool\",\"shortName\":\"Liv'pool\",\"threeCharsName\":\"LIV\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/8650.png\"}]},{\"id\":2252192,\"name\":\"Leicester - Arsenal\",\"startDate\":1471710600,\"countryId\":2,\"countryName\":\"England\",\"tournamentId\":47,\"tournamentName\":\"Premier League\",\"tournamentShortName\":\"Premier L.\",\"sportId\":1,\"statusId\":1,\"statusCode\":\"notstarted\",\"statusDesc\":\"Not started\",\"statusShortDesc\":\"NS\",\"elapsed\":0,\"elapsedText\":null,\"isTicking\":false,\"ballPossession\":0,\"outcome\":null,\"predictionOpened\":true,\"teams\":[{\"id\":8197,\"number\":1,\"name\":\"Leicester\",\"shortName\":\"Leicester\",\"threeCharsName\":\"LEI\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/8197.png\"},{\"id\":9825,\"number\":2,\"name\":\"Arsenal\",\"shortName\":\"Arsenal\",\"threeCharsName\":\"ARS\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/9825.png\"}]},{\"id\":2252196,\"name\":\"Sunderland - Middlesbrough\",\"startDate\":1471782600,\"countryId\":2,\"countryName\":\"England\",\"tournamentId\":47,\"tournamentName\":\"Premier League\",\"tournamentShortName\":\"Premier L.\",\"sportId\":1,\"statusId\":1,\"statusCode\":\"notstarted\",\"statusDesc\":\"Not started\",\"statusShortDesc\":\"NS\",\"elapsed\":0,\"elapsedText\":null,\"isTicking\":false,\"ballPossession\":0,\"outcome\":null,\"predictionOpened\":true,\"teams\":[{\"id\":8472,\"number\":1,\"name\":\"Sunderland\",\"shortName\":\"Sun'land\",\"threeCharsName\":\"SUN\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/8472.png\"},{\"id\":8549,\"number\":2,\"name\":\"Middlesbrough\",\"shortName\":\"Mid'brough\",\"threeCharsName\":\"MID\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/8549.png\"}]},{\"id\":2252201,\"name\":\"West Ham - Bournemouth\",\"startDate\":1471791600,\"countryId\":2,\"countryName\":\"England\",\"tournamentId\":47,\"tournamentName\":\"Premier League\",\"tournamentShortName\":\"Premier L.\",\"sportId\":1,\"statusId\":1,\"statusCode\":\"notstarted\",\"statusDesc\":\"Not started\",\"statusShortDesc\":\"NS\",\"elapsed\":0,\"elapsedText\":null,\"isTicking\":false,\"ballPossession\":0,\"outcome\":null,\"predictionOpened\":true,\"teams\":[{\"id\":8654,\"number\":1,\"name\":\"West Ham\",\"shortName\":\"W. Ham\",\"threeCharsName\":\"WHA\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/8654.png\"},{\"id\":8678,\"number\":2,\"name\":\"Bournemouth\",\"shortName\":\"Bournemouth\",\"threeCharsName\":\"BOU\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/8678.png\"}]},{\"id\":2252209,\"name\":\"Tottenham - Liverpool\",\"startDate\":1472297400,\"countryId\":2,\"countryName\":\"England\",\"tournamentId\":47,\"tournamentName\":\"Premier League\",\"tournamentShortName\":\"Premier L.\",\"sportId\":1,\"statusId\":1,\"statusCode\":\"notstarted\",\"statusDesc\":\"Not started\",\"statusShortDesc\":\"NS\",\"elapsed\":0,\"elapsedText\":null,\"isTicking\":false,\"ballPossession\":0,\"outcome\":null,\"predictionOpened\":true,\"teams\":[{\"id\":8586,\"number\":1,\"name\":\"Tottenham\",\"shortName\":\"Tott'ham\",\"threeCharsName\":\"TOT\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/8586.png\"},{\"id\":8650,\"number\":2,\"name\":\"Liverpool\",\"shortName\":\"Liv'pool\",\"threeCharsName\":\"LIV\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/8650.png\"}]},{\"id\":2252202,\"name\":\"Chelsea - Burnley\",\"startDate\":1472306400,\"countryId\":2,\"countryName\":\"England\",\"tournamentId\":47,\"tournamentName\":\"Premier League\",\"tournamentShortName\":\"Premier L.\",\"sportId\":1,\"statusId\":1,\"statusCode\":\"notstarted\",\"statusDesc\":\"Not started\",\"statusShortDesc\":\"NS\",\"elapsed\":0,\"elapsedText\":null,\"isTicking\":false,\"ballPossession\":0,\"outcome\":null,\"predictionOpened\":true,\"teams\":[{\"id\":8455,\"number\":1,\"name\":\"Chelsea\",\"shortName\":\"Chelsea\",\"threeCharsName\":\"CHE\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/8455.png\"},{\"id\":8191,\"number\":2,\"name\":\"Burnley\",\"shortName\":\"Burnley\",\"threeCharsName\":\"BUR\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/8191.png\"}]},{\"id\":2252203,\"name\":\"Crystal Palace - Bournemouth\",\"startDate\":1472306400,\"countryId\":2,\"countryName\":\"England\",\"tournamentId\":47,\"tournamentName\":\"Premier League\",\"tournamentShortName\":\"Premier L.\",\"sportId\":1,\"statusId\":1,\"statusCode\":\"notstarted\",\"statusDesc\":\"Not started\",\"statusShortDesc\":\"NS\",\"elapsed\":0,\"elapsedText\":null,\"isTicking\":false,\"ballPossession\":0,\"outcome\":null,\"predictionOpened\":true,\"teams\":[{\"id\":9826,\"number\":1,\"name\":\"Crystal Palace\",\"shortName\":\"Crystal P.\",\"threeCharsName\":\"CRY\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/9826.png\"},{\"id\":8678,\"number\":2,\"name\":\"Bournemouth\",\"shortName\":\"Bournemouth\",\"threeCharsName\":\"BOU\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/8678.png\"}]},{\"id\":2252204,\"name\":\"Everton - Stoke\",\"startDate\":1472306400,\"countryId\":2,\"countryName\":\"England\",\"tournamentId\":47,\"tournamentName\":\"Premier League\",\"tournamentShortName\":\"Premier L.\",\"sportId\":1,\"statusId\":1,\"statusCode\":\"notstarted\",\"statusDesc\":\"Not started\",\"statusShortDesc\":\"NS\",\"elapsed\":0,\"elapsedText\":null,\"isTicking\":false,\"ballPossession\":0,\"outcome\":null,\"predictionOpened\":true,\"teams\":[{\"id\":8668,\"number\":1,\"name\":\"Everton\",\"shortName\":\"Everton\",\"threeCharsName\":\"EVE\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/8668.png\"},{\"id\":10194,\"number\":2,\"name\":\"Stoke\",\"shortName\":\"Stoke\",\"threeCharsName\":\"STO\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/10194.png\"}]},{\"id\":2252206,\"name\":\"Leicester - Swansea\",\"startDate\":1472306400,\"countryId\":2,\"countryName\":\"England\",\"tournamentId\":47,\"tournamentName\":\"Premier League\",\"tournamentShortName\":\"Premier L.\",\"sportId\":1,\"statusId\":1,\"statusCode\":\"notstarted\",\"statusDesc\":\"Not started\",\"statusShortDesc\":\"NS\",\"elapsed\":0,\"elapsedText\":null,\"isTicking\":false,\"ballPossession\":0,\"outcome\":null,\"predictionOpened\":true,\"teams\":[{\"id\":8197,\"number\":1,\"name\":\"Leicester\",\"shortName\":\"Leicester\",\"threeCharsName\":\"LEI\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/8197.png\"},{\"id\":10003,\"number\":2,\"name\":\"Swansea\",\"shortName\":\"Swansea\",\"threeCharsName\":\"SWA\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/10003.png\"}]},{\"id\":2252208,\"name\":\"Southampton - Sunderland\",\"startDate\":1472306400,\"countryId\":2,\"countryName\":\"England\",\"tournamentId\":47,\"tournamentName\":\"Premier League\",\"tournamentShortName\":\"Premier L.\",\"sportId\":1,\"statusId\":1,\"statusCode\":\"notstarted\",\"statusDesc\":\"Not started\",\"statusShortDesc\":\"NS\",\"elapsed\":0,\"elapsedText\":null,\"isTicking\":false,\"ballPossession\":0,\"outcome\":null,\"predictionOpened\":true,\"teams\":[{\"id\":8466,\"number\":1,\"name\":\"Southampton\",\"shortName\":\"Sou'ton\",\"threeCharsName\":\"SOU\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/8466.png\"},{\"id\":8472,\"number\":2,\"name\":\"Sunderland\",\"shortName\":\"Sun'land\",\"threeCharsName\":\"SUN\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/8472.png\"}]},{\"id\":2252210,\"name\":\"Watford - Arsenal\",\"startDate\":1472306400,\"countryId\":2,\"countryName\":\"England\",\"tournamentId\":47,\"tournamentName\":\"Premier League\",\"tournamentShortName\":\"Premier L.\",\"sportId\":1,\"statusId\":1,\"statusCode\":\"notstarted\",\"statusDesc\":\"Not started\",\"statusShortDesc\":\"NS\",\"elapsed\":0,\"elapsedText\":null,\"isTicking\":false,\"ballPossession\":0,\"outcome\":null,\"predictionOpened\":true,\"teams\":[{\"id\":9817,\"number\":1,\"name\":\"Watford\",\"shortName\":\"Watford\",\"threeCharsName\":\"WAT\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/9817.png\"},{\"id\":9825,\"number\":2,\"name\":\"Arsenal\",\"shortName\":\"Arsenal\",\"threeCharsName\":\"ARS\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/9825.png\"}]},{\"id\":2252205,\"name\":\"Hull - Manchester United\",\"startDate\":1472315400,\"countryId\":2,\"countryName\":\"England\",\"tournamentId\":47,\"tournamentName\":\"Premier League\",\"tournamentShortName\":\"Premier L.\",\"sportId\":1,\"statusId\":1,\"statusCode\":\"notstarted\",\"statusDesc\":\"Not started\",\"statusShortDesc\":\"NS\",\"elapsed\":0,\"elapsedText\":null,\"isTicking\":false,\"ballPossession\":0,\"outcome\":null,\"predictionOpened\":true,\"teams\":[{\"id\":8667,\"number\":1,\"name\":\"Hull\",\"shortName\":\"Hull\",\"threeCharsName\":\"HUL\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/8667.png\"},{\"id\":10260,\"number\":2,\"name\":\"Manchester United\",\"shortName\":\"Man Utd\",\"threeCharsName\":\"MU\",\"redCardsTotal\":0,\"results\":null,\"outcome\":null,\"logoUrl\":\"http:\\/\\/medias.whatsthescore.com\\/logos\\/icons\\/app-teams-large-ios-retina\\/10260.png\"}]}]}";
        Gson gson = new Gson();
        League league = gson.fromJson(jsonString, League.class);
        List<League> leagueList = new ArrayList<>();
        leagueList.add(league);
        callback.onSuccess(leagueList);
    }

    @Override
    public void matchesFromTournament(String tournamentId, DataCallback<List<League>> callback) {

    }
}
