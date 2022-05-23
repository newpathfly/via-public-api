package com.via.api.model;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.via.api.model.Search.Request;
import com.via.api.model.enums.ClassType;
import com.via.api.model.enums.RouteType;
import com.via.api.utils.ModelValidator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.SneakyThrows;

class SearchTest {
    private final static ObjectMapper OBJECT_MAPPER = JsonMapper.builder()
            .addModule(new JavaTimeModule())
            .build();

    private final static ModelValidator BASIC_REQUEST_VALIDATOR = new ModelValidator();

    @Test
    @SneakyThrows
    void negativeTest_EmptySearchRequest() {

        Search.Request request = Search.Request.builder().build();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            BASIC_REQUEST_VALIDATOR.validate(request);
        });

        String json = OBJECT_MAPPER.writeValueAsString(request);

        Assertions.assertNotNull(json);
    }

    @Test
    @SneakyThrows
    void positiveTest_SearchRequest() {

        Search.Request expectedRequest = buildSearchRequest();

        BASIC_REQUEST_VALIDATOR.validate(expectedRequest);

        String json = OBJECT_MAPPER.writeValueAsString(expectedRequest);

        Assertions.assertEquals(-1, json.indexOf("null"), json);

        Search.Request actualRequest = OBJECT_MAPPER.readValue(json, Search.Request.class);

        assertEquals(expectedRequest, actualRequest);
    }

    @Test
    @SneakyThrows
    void positiveTest_SearchResponse() {

        for (String samplePath : new String[] {
                "/samples/SearchResponse_OW.json",
                "/samples/SearchResponse_RT.json",
        }) {
            Search.Response response = null;

            try (InputStream is = getClass().getResourceAsStream(samplePath)) {
                response = OBJECT_MAPPER.readValue(is, Search.Response.class);
            }

            BASIC_REQUEST_VALIDATOR.validate(response);
        }
    }

    private void assertEquals(Request expected, Request actual) {

        assertEqualsSectorInfos(expected.getSectorInfos(), actual.getSectorInfos());
        assertEquals(expected.getPaxCount(), actual.getPaxCount());
        assertEqualsCarriers(expected.getPrefAirlines(), actual.getPrefAirlines());

        Assertions.assertEquals(expected.getRoute(), actual.getRoute());
        Assertions.assertEquals(expected.getClassType(), actual.getClassType());
        Assertions.assertEquals(expected.getMultiCity(), actual.getMultiCity());
    }

    private static Search.Request buildSearchRequest() {

        SectorInfo sectorInfo = buildSectorInfo();

        PaxCount paxCount = buildPaxCount();

        Carrier prefAirline = buildCarrier();

        return Search.Request.builder()
                .sectorInfo(sectorInfo)
                .paxCount(paxCount)
                .route(RouteType.ALL)
                .classType(ClassType.ECONOMY)
                .prefAirline(prefAirline)
                .build();
    }

    private static SectorInfo buildSectorInfo() {

        Airport airport1 = buildAirport("HEL");
        Airport airport2 = buildAirport("SIN");

        return SectorInfo.builder()
                .src(airport1)
                .dest(airport2)
                .date(LocalDate.of(2022, 06, 28))
                .build();
    }

    private static Airport buildAirport(String code) {

        return Airport.builder()
                .code(code)
                .build();
    }

    private static PaxCount buildPaxCount() {

        return PaxCount.builder()
                .adt(2)
                .chd(1)
                .inf(0)
                .build();
    }

    private static Carrier buildCarrier() {

        return Carrier.builder()
                .code("SJ")
                .build();
    }

    private static void assertEqualsSectorInfos(List<SectorInfo> expected, List<SectorInfo> actual) {

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

    private static void assertEquals(PaxCount expected, PaxCount actual) {
        Assertions.assertEquals(expected.getAdt(), actual.getAdt());
        Assertions.assertEquals(expected.getChd(), actual.getChd());
        Assertions.assertEquals(expected.getInf(), actual.getInf());
    }

    private static void assertEqualsCarriers(List<Carrier> expected, List<Carrier> actual) {
        Assertions.assertEquals(expected.size(), actual.size());

        Iterator<Carrier> expectedSectorInfoIterator = expected.iterator();
        Iterator<Carrier> actualSectorInfoIterator = actual.iterator();

        while (true) {

            if (!expectedSectorInfoIterator.hasNext() || !actualSectorInfoIterator.hasNext()) {
                break;
            }

            Carrier expectedCarrier = expectedSectorInfoIterator.next();
            Carrier actualCarrier = actualSectorInfoIterator.next();

            assertEquals(expectedCarrier, actualCarrier);
        }
    }

    private static void assertEquals(Carrier expected, Carrier actual) {
        Assertions.assertEquals(expected.getCode(), actual.getCode());
        Assertions.assertEquals(expected.getName(), actual.getName());
    }
}
