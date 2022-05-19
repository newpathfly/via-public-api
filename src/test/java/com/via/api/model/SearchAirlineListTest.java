package com.via.api.model;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.via.api.model.enums.RouteType;
import com.via.api.utils.ModelValidator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.SneakyThrows;

class SearchAirlineListTest {

    private final static ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private final static ModelValidator BASIC_REQUEST_VALIDATOR = new ModelValidator();

    @Test
    @SneakyThrows
    void negativeTest_EmptySearchAirlineListRequest() {

        SearchAirlineList.Request request = SearchAirlineList.Request.builder().build();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            BASIC_REQUEST_VALIDATOR.validate(request);
        });

        String json = OBJECT_MAPPER.writeValueAsString(request);

        Assertions.assertNotNull(json);
    }

    @Test
    @SneakyThrows
    void positiveTest_SearchAirlineListRequest() {

        SearchAirlineList.Request expectedRequest = buildSearchAirlineListRequest();

        BASIC_REQUEST_VALIDATOR.validate(expectedRequest);

        String json = OBJECT_MAPPER.writeValueAsString(expectedRequest);

        SearchAirlineList.Request actualRequest = OBJECT_MAPPER.readValue(json, SearchAirlineList.Request.class);

        assertEquals(expectedRequest, actualRequest);
    }

    @Test
    @SneakyThrows
    void positiveTest_SearchAirlineListResponse() {
        String samplePath = "/samples/SearchAirlineListResponse.json";

        SearchAirlineList.Response response = null;

        try (InputStream is = getClass().getResourceAsStream(samplePath)) {
            response = OBJECT_MAPPER.readValue(is, SearchAirlineList.Response.class);
        }

        BASIC_REQUEST_VALIDATOR.validate(response);
    }

    private static void assertEquals(SearchAirlineList.Request expected, SearchAirlineList.Request actual) {
        assertEquals(expected.getSectorInfos(), actual.getSectorInfos());
        assertEquals(expected.getPaxCount(), actual.getPaxCount());
        Assertions.assertEquals(expected.getRoute(), actual.getRoute());
    }

    private static void assertEquals(List<SectorInfo> expected, List<SectorInfo> actual) {

        Assertions.assertEquals(expected.size(), actual.size());

        Iterator<SectorInfo> expectedSectorInfoIterator = expected.iterator();
        Iterator<SectorInfo> actualSectorInfoIterator = actual.iterator();

        while (true) {

            if (!expectedSectorInfoIterator.hasNext() || !actualSectorInfoIterator.hasNext()) {
                break;
            }

            SectorInfo expectedSectorInfo = expectedSectorInfoIterator.next();
            SectorInfo actualSectorInfo = actualSectorInfoIterator.next();

            assertEquals(expectedSectorInfo, actualSectorInfo);
        }
    }

    private static void assertEquals(PaxCount expected, PaxCount actual) {
        Assertions.assertEquals(expected.getAdt(), actual.getAdt());
        Assertions.assertEquals(expected.getChd(), actual.getChd());
        Assertions.assertEquals(expected.getInf(), actual.getInf());
    }

    private static void assertEquals(SectorInfo expectedSectorInfo, SectorInfo actualSectorInfo) {
        assertEquals(expectedSectorInfo.getSrc(), actualSectorInfo.getSrc());
        assertEquals(expectedSectorInfo.getDest(), actualSectorInfo.getDest());
        Assertions.assertEquals(expectedSectorInfo.getDate(), actualSectorInfo.getDate());
    }

    private static void assertEquals(Airport expectedPlace, Airport actualPlace) {
        Assertions.assertEquals(expectedPlace.getCode(), actualPlace.getCode());
        Assertions.assertEquals(expectedPlace.getName(), actualPlace.getName());
        Assertions.assertEquals(expectedPlace.getCity(), actualPlace.getCity());
        Assertions.assertEquals(expectedPlace.getCountry(), actualPlace.getCountry());
    }

    private static SearchAirlineList.Request buildSearchAirlineListRequest() {
        SectorInfo sectorInfo = buildSectorInfo();

        PaxCount paxCount = buildPaxCount();

        return SearchAirlineList.Request.builder()
                .sectorInfo(sectorInfo)
                .paxCount(paxCount)
                .route(RouteType.ALL)
                .build();
    }

    private static SectorInfo buildSectorInfo() {
        Airport place1 = buildPlace("CGK");
        Airport place2 = buildPlace("SUB");

        return SectorInfo.builder()
                .src(place1)
                .dest(place2)
                .date("2017-05-26")
                .build();
    }

    private static Airport buildPlace(String code) {
        return Airport.builder()
                .code(code)
                .build();
    }

    private static PaxCount buildPaxCount() {
        return PaxCount.builder()
                .adt(1)
                .chd(0)
                .inf(0)
                .build();
    }
}
