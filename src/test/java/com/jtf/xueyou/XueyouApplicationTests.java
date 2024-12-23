package com.jtf.xueyou;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jtf.xueyou.dto.ClubDTO;
import com.jtf.xueyou.entity.Club;
import com.jtf.xueyou.service.ClubService;
import org.apache.commons.io.FilenameUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class XueyouApplicationTests {

    @Autowired
    private ClubService clubService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void importClubData() throws IOException {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("DIY手工坊", 7);
        map.put("KTV", 1);
        map.put("休闲露营", 6);
        map.put("剧本杀", 5);
        map.put("密室", 4);
        map.put("棋牌室", 8);
        map.put("运动健身", 3);
        map.put("酒吧", 2);

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("classpath:clubs/*.json");

        for (Resource resource : resources) {
            String filename = FilenameUtils.getBaseName(resource.getFilename());
            System.out.println("Processing file: " + filename + " " + map.get(filename));
            // 使用 TypeReference 来指定数组中元素的类型
            Club[] clubs = objectMapper.readValue(resource.getInputStream(), Club[].class);
            for (Club club : clubs) {
//                System.out.println(club);
                ClubDTO clubDTO = new ClubDTO();
                BeanUtils.copyProperties(club,clubDTO);
                clubDTO.setTypeIds(Collections.singletonList(map.get(filename)));
//                System.out.println(clubDTO);
                clubService.addClub(clubDTO);
            }
        }
    }


}
