package com.exxeta.iss.sonar.msgflow.parser.node.mq;

import javax.xml.xpath.XPathExpressionException;

import org.sonar.api.utils.log.Logger;
import org.sonar.api.utils.log.Loggers;
import org.w3c.dom.Element;

import com.exxeta.iss.sonar.msgflow.parser.node.NodeParser;
import com.exxeta.iss.sonar.msgflow.tree.impl.node.mq.MQOutputNodeImpl;

public class MQOutputNodeParser extends NodeParser<MQOutputNodeImpl> {

	private static final String NODE_TYPE = "ComIbmMQOutput.msgnode";
	private static final Logger LOGGER = Loggers.get(MQOutputNodeParser.class);

	@Override
	public String getNodeType() {
		return NODE_TYPE;
	}

	@Override
	public MQOutputNodeImpl parseMessageFlowNode(final Element nodeElement) {

		try {
			return new MQOutputNodeImpl(nodeElement, getId(nodeElement), getName(nodeElement), getLocationX(nodeElement),
					getLocationY(nodeElement), nodeElement.getAttribute("queueName"));
		} catch (final XPathExpressionException e) {
			LOGGER.error("cannot parse AggregateControlNode", e);
			return null;
		}

	}

}