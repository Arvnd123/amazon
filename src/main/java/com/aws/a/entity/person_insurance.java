package com.aws.a.entity;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBDocument
public class person_insurance {

    public int getPolicy_no() {
		return policy_no;
	}

	public void setPolicy_no(int policy_no) {
		this.policy_no = policy_no;
	}

	public String getPolicy_name() {
		return policy_name;
	}

	public void setPolicy_name(String policy_name) {
		this.policy_name = policy_name;
	}

	@DynamoDBAttribute
    private int policy_no;

    @DynamoDBAttribute
    private  String policy_name;

	
    
}