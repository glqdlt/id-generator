package com.glqdlt.support;

/**
 * @author glqdlt
 */
public interface IdGenerator {
    /**
     * 32 길이의 랜덤 문자열로 된 id 를 생성하여 반환
     * @return id 를 반환
     */
    String generate();

    /**
     * 32 길이의 랜덤 문자열 id 의 검증
     * @param id 검증이 필요한 id
     * @return 검증 결과 true = 정상, false = 잘못된 형태
     */
    Boolean verify(String id);
}
