package com.finvivir.process.bi.unit.consume.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "RouteToOperate", description = "Information of route so that the user can operate it")
public class RouteToOperateDto {

	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	@Schema(name = "GroupToOperate", description = "Information of group so that the user can operate it")
	public static class GroupToOperateDto {
	
		@Schema(name = "id", description = "Identifier of group", example = "23")
		private Integer id;
		
		@Schema(name = "name", description = "Name of group", example = "TEQUILA")
		private String name;
		
		@Schema(name = "operatesToday", description = "Flag indicating if this group is operated today", example = "true")
		private Boolean operatesToday;
		
		@JsonInclude(value = JsonInclude.Include.NON_NULL)
		@Schema(name = "groupLeader", description = "Identifier of group Leader")
		private String groupLeaderId;
		
		@JsonInclude(value = JsonInclude.Include.NON_NULL)
		@Schema(name = "groupLeaderCategory", description = "Identifier of group Leader category")
		private String groupLeaderCategory;
		
		@JsonInclude(value = JsonInclude.Include.NON_NULL)
		@Schema(name = "payments", description = "List with payments in group to collect")
		private List<PaymentDto> payments;
		
		/**
		 * @param group with data to convert in GroupToOperateDto
		 * @param dayOfWeek with name of current day
		 * @return GroupToOperateDto created with data provided
		 */
		public static GroupToOperateDto toDto(Group group, String dayOfWeek) {
			return GroupToOperateDto.builder()
					.id(group.getId())
					.name(group.getName())
					.operatesToday(dayOfWeek.equals(group.getOperationDay()))
					.build();
		}
	}
	
	@Schema(name = "brandCode", description = "Code of brand to operate", example = "CVM")
	private String brandCode;
	
	@Schema(name = "regionCode", description = "Code of region to operate", example = "CVMJAL")
	private String regionCode;
	
	@Schema(name = "routeCode", description = "Code of route to operate", example = "CVMJAL01")
	private String routeCode;
	
	@Schema(name = "date", description = "Date of consult in format yyyy-MM-dd", example = "2022-05-15")
	private LocalDate date;
	
	private List<GroupToOperateDto> groups;
	
	/**
	 * @param route with information of route to operate
	 * @date with date to operate
	 * @groups with list of groups to operate
	 * @return RouteToOperateDto created with data provided
	 */
	public static RouteToOperateDto toDto(Route route, LocalDate date, List<Group> groups) {
		
		List<GroupToOperateDto> groupsToOperate = new ArrayList<>();
		String dayOfWeek = date.getDayOfWeek().name(); // get name of day in date provided
		
		for(Group g: groups) { // transform each group in DTO
			groupsToOperate.add(GroupToOperateDto.toDto(g, dayOfWeek));
		}
		
		return RouteToOperateDto.builder() // return route to operate
				.routeCode(route.getCode())
				.regionCode(route.getRegionCode())
				.brandCode(route.getParents().getBrandCode())
				.date(date)
				.groups(groupsToOperate)
				.build();
	}
}
